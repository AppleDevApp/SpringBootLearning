package com.appledevapp.learning.excelexport.util;

import com.appledevapp.learning.excelexport.entity.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 数据导出帮助类
 */
public class DataExportor {

    /**
     * 导出数据为Excel到请求中
     *
     * @param fileName 文件名称,带拓展名
     * @param request  HTTP请求
     * @param response HTTP响应
     * @throws IOException 异常
     */
    public static void exportToExcel(String fileName, ExcelConfig excelConfig, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userAgent = request.getHeader("USER-AGENT");
        if (StringUtils.contains(userAgent, "MSIE")) {
            //IE浏览器
            fileName = URLEncoder.encode(fileName, "UTF8");
        } else if (StringUtils.contains(userAgent, "Mozilla")) {
            //google,火狐浏览器
            fileName = new String(fileName.getBytes(), "ISO8859-1");
        } else {
            //其他浏览器
            fileName = URLEncoder.encode(fileName, "UTF8");
        }

        response.setContentType("application/octet-stream;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        exportToExcel(excelConfig, servletOutputStream);
        IOUtils.closeQuietly(servletOutputStream);
    }

    /**
     * 导出到Excel
     *
     * @param excelConfig 表格配置
     * @param stream      输出流
     * @throws IOException 异常
     */
    public static void exportToExcel(ExcelConfig excelConfig, OutputStream stream) throws IOException {

        if (excelConfig == null) {
            throw new IllegalArgumentException("Excel配置不能为NULL");
        }

        //创建和填充Excel
        Workbook workbook = new XSSFWorkbook();

        //判断Excel配置类型
        if (excelConfig.getGroupType().equals(ExcelConfig.GroupType.PagerByNum)) {
            subLayoutForPager(workbook, excelConfig);
        } else {
            subLayoutForGroup(workbook, excelConfig);
        }

        //把工作表写入到输出流
        workbook.write(stream);
        workbook.close();
    }

    /**
     * 布局分页
     *
     * @param workbook    表格
     * @param excelConfig 配置
     */
    private static void subLayoutForPager(Workbook workbook, ExcelConfig excelConfig) {
        List<ExcelArea> areaList = excelConfig.getAreaList();
        if (CollectionUtils.isEmpty(areaList) || areaList.size() > 1) {
            throw new IllegalArgumentException("Excel分页只支持单区域");
        }

        //计算分页数
        ExcelArea excelArea = areaList.get(0);

        double sheetNum = Math.ceil(excelArea.getAreaDataList().size() / excelConfig.getPageSize().doubleValue());

        Sheet sheet;
        String sheetTabName;

        int pageSize = excelConfig.getPageSize();
        for (int pageIndex = 0; pageIndex < sheetNum; pageIndex++) {
            //设置Sheet的底部名称
            sheetTabName = sheetNum == 1 ? excelConfig.getSheetName() : excelConfig.getSheetName() + (pageIndex + 1);

            sheet = workbook.createSheet(sheetTabName);

            //填充工作表
            fillInSheetDataByPager(sheet, excelArea, pageIndex, pageSize);
        }
    }

    /**
     * 布局分组
     *
     * @param workbook    表格
     * @param excelConfig 配置
     */
    private static void subLayoutForGroup(Workbook workbook, ExcelConfig excelConfig) {

        if (CollectionUtils.isEmpty(excelConfig.getAreaList())) {
            throw new IllegalArgumentException("Excel分组组别不能为空");
        }

        Sheet sheet;
        String sheetTabName;

        //设置Sheet的底部名称
        sheetTabName = excelConfig.getSheetName();
        sheet = workbook.createSheet(sheetTabName);

        //是否需要设置列宽度
        //sheet.setDefaultColumnWidth(20);
        List<ExcelArea> areaList = excelConfig.getAreaList();

        AtomicInteger rowNo = new AtomicInteger();
        //循环组别
        for (ExcelArea excelArea : areaList) {
            //填充工作表
            fillInSheetDataByGroup(sheet, excelArea, rowNo);
        }

    }

    /**
     * 绘制区域头部
     *
     * @param sheet     表格
     * @param excelArea 区域块
     * @param rowNo     行号
     * @return 合并列表
     */
    private static List<CellRangeAddress> makeAreaHeader(Sheet sheet, ExcelArea excelArea, int rowNo) {

        //绘制表头
        List<CellRangeAddress> mergerRuleList = new ArrayList<>();
        if (CollectionUtils.isEmpty(excelArea.getHeaderRuleList())) {
            return mergerRuleList;
        }

        Cell cell;
        Row row;
        for (HeaderRule rule : excelArea.getHeaderRuleList()) {
            row = obtainRowAtIndex(sheet, rowNo + rule.getFirstRow());
            cell = obtainCellAtIndex(row, rule.getFirstColumn());
            cell.setCellValue(rule.getColumnName());
            if (rule.isNeedMerge()) {
                mergerRuleList.add(rule.buildRule(rowNo));
            }
        }

        return mergerRuleList;
    }

    /**
     * 填充表格数据-分页模式
     *
     * @param sheet     表格
     * @param excelArea 区域块
     */
    private static void fillInSheetDataByPager(Sheet sheet, ExcelArea excelArea, int pageIndex, int pageSize) {

        //绘制表头
        int rowNo = excelArea.getRowPaddingTop();
        List<CellRangeAddress> mergerRuleList = makeAreaHeader(sheet, excelArea, rowNo);

        //行间距表头距离
        rowNo = rowNo + excelArea.getRowPaddingTop() + 1;

        List areaDataList = excelArea.getAreaDataList();
        int firstIndex = pageIndex * pageSize;
        int lastIndex = (pageIndex + 1) * pageSize > areaDataList.size() ? areaDataList.size() - 1 : (pageIndex + 1) * pageSize - 1;

        List<CellRangeAddress> rowMergerRuleList;
        Object item;
        for (int index = firstIndex; index <= lastIndex; index++) {

            //获取单个对象
            item = areaDataList.get(index);
            rowMergerRuleList = fillCellData(sheet, excelArea, item, rowNo);
            mergerRuleList.addAll(rowMergerRuleList);

            rowNo++;
        }

        //需要进行单元格合并
        layoutMergeRules(sheet, mergerRuleList);
    }

    private static void layoutMergeRules(Sheet sheet, List<CellRangeAddress> mergerRuleList) {
        //需要进行单元格合并
        if (CollectionUtils.isNotEmpty(mergerRuleList)) {
            for (CellRangeAddress mergeRule : mergerRuleList) {
                sheet.addMergedRegion(mergeRule);
            }
        }
    }

    private static List<CellRangeAddress> fillCellData(Sheet sheet, ExcelArea excelArea, Object item, int rowNo) {

        LinkedHashMap<String, ExcelField> fieldMap = excelArea.getFieldMap();
        //定义存放英文字段名和中文字段名的数组
        String[] enFields = new String[fieldMap.size()];
        ExcelField[] cnFields = new ExcelField[fieldMap.size()];

        //填充字段映射数组
        final int[] count = {0};
        fieldMap.forEach((k, v) -> {
            enFields[count[0]] = k;
            cnFields[count[0]] = v;
            count[0]++;
        });

        Cell cell;
        //创建新行
        Row row = obtainRowAtIndex(sheet, rowNo);
        List<CellRangeAddress> mergerRuleList = new ArrayList<>();

        //填充内容
        String fieldValue;

        //获取单个对象
        Map<Object, Object> dataMap = DataConvertor.toMap(item);
        for (int i = 0; i < enFields.length; i++) {
            fieldValue = getFieldValueByName(dataMap, rowNo, enFields[i], cnFields[i]);
            cell = obtainCellAtIndex(row, i);
            cell.setCellValue(fieldValue);
        }

        //判断该行是否满足行合并规则
        if (CollectionUtils.isNotEmpty(excelArea.getRowRuleList())) {
            boolean isRowNeedMerge;
            for (RowRule rowRule : excelArea.getRowRuleList()) {
                isRowNeedMerge = rowRule.isNeedMerge(dataMap, rowNo);
                if (isRowNeedMerge) {
                    mergerRuleList.add(rowRule.buildRule(dataMap, rowNo));
                }
            }
        }

        return mergerRuleList;

    }

    private static void fillInSheetDataByGroup(Sheet sheet, ExcelArea excelArea, AtomicInteger rowIndex) {

        //绘制表头
        int rowNo = rowIndex.addAndGet(excelArea.getRowPaddingTop());
        final List<CellRangeAddress> mergerRuleList = makeAreaHeader(sheet, excelArea, rowNo);

        //填充内容
        //行间距表头距离
        rowNo = rowIndex.addAndGet(excelArea.getRowPaddingTop() + 1);

        List<CellRangeAddress> rowMergerRuleList;
        Object item;
        List areaDataList = excelArea.getAreaDataList();

        for (Object anAreaDataList : areaDataList) {
            //获取单个对象
            item = anAreaDataList;
            rowMergerRuleList = fillCellData(sheet, excelArea, item, rowNo);
            mergerRuleList.addAll(rowMergerRuleList);

            rowNo = rowIndex.incrementAndGet();
        }

        //需要进行单元格合并
        layoutMergeRules(sheet, mergerRuleList);
    }

    /**
     * 获取字段值-应用函数转换
     *
     * @param dataMap    数据字典
     * @param rowNum     行号
     * @param fieldName  字段名称
     * @param excelField Excel字段约束
     * @return 转换为字符的值
     */
    private static String getFieldValueByName(Map<Object, Object> dataMap, Integer rowNum, String fieldName, ExcelField excelField) {
        return excelField.applyFunc(dataMap, rowNum, fieldName);
    }


    /**
     * 根据指定行号获取行
     *
     * @param sheet  表格
     * @param rowNum 行号
     * @return 行
     */
    private static Row obtainRowAtIndex(Sheet sheet, Integer rowNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        return row;
    }

    /**
     * 根据指定行号和列号获取列
     *
     * @param row     行号
     * @param cellNum 列号
     * @return 列
     */
    private static Cell obtainCellAtIndex(Row row, Integer cellNum) {
        Cell cell = row.getCell(cellNum);
        if (cell == null) {
            cell = row.createCell(cellNum);
        }
        return cell;
    }
}

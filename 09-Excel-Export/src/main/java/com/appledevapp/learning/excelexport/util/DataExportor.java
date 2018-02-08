package com.appledevapp.learning.excelexport.util;

import com.appledevapp.learning.excelexport.entity.ExcelField;
import com.appledevapp.learning.excelexport.entity.HeaderRule;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据导出帮助类
 */
public class DataExportor {

    /**
     * 每一页最大行数
     */
    public static final int MAX_SHEET_SIZE = 65535;

    /**
     * 导出数据为Excel到请求中
     *
     * @param fileName  文件名称,带拓展名
     * @param dataList  数据列表
     * @param fieldMap  字段映射字典
     * @param sheetName Sheet名称
     * @param sheetSize Sheet长度
     * @param request   HTTP请求
     * @param response  HTTP响应
     * @param <T>       列表类型
     * @throws IOException 异常
     */
    public static <T> void exportToExcel(String fileName, List<T> dataList, LinkedHashMap<String, ExcelField> fieldMap, String sheetName, int sheetSize, HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        exportToExcel(dataList, fieldMap, sheetName, sheetSize, servletOutputStream);
        IOUtils.closeQuietly(servletOutputStream);
    }

    /**
     * 导出数据为Excel到请求中
     *
     * @param dataList  数据列表
     * @param fieldMap  字段映射字典
     * @param sheetName Sheet名称
     * @param sheetSize Sheet长度
     * @param <T>       列表类型
     * @throws IOException 异常
     */
    public static <T> void exportToExcel(List<T> dataList, LinkedHashMap<String, ExcelField> fieldMap, String sheetName, int sheetSize, OutputStream stream) throws IOException {

        if (dataList == null) {
            throw new IllegalArgumentException("列表数据不能为NULL");
        }

        //每一页数据能够存放多少条
        if (sheetSize == -1) {
            sheetSize = dataList.size();
        } else {
            if (sheetSize > MAX_SHEET_SIZE || sheetSize < 1) {
                sheetSize = MAX_SHEET_SIZE;
            }
        }

        //计算总数据需要区分多少页
        double sheetNum = Math.ceil(dataList.size() / new Integer(sheetSize).doubleValue());

        //创建和填充Excel
        Workbook workbook = new XSSFWorkbook();

        String sheetTabName;
        for (int i = 0; i < sheetNum; i++) {
            //设置Sheet的底部名称
            sheetTabName = sheetNum == 1 ? sheetName : sheetName + (i + 1);

            Sheet sheet = workbook.createSheet(sheetTabName);

            //是否需要设置列宽度
            //sheet.setDefaultColumnWidth(20);

            //获取开始索引和结束索引
            int firstIndex = i * sheetSize;
            int lastIndex = (i + 1) * sheetSize > dataList.size() ? dataList.size() - 1 : (i + 1) * sheetSize - 1;

            //填充工作表
            fillInSheetData(sheet, dataList, fieldMap, firstIndex, lastIndex);
        }

        //把工作表写入到输出流
        workbook.write(stream);
        workbook.close();
    }

    /**
     * 填充数据方法
     *
     * @param sheet      Sheet表
     * @param dataList   数据集
     * @param fieldMap   字段映射
     * @param firstIndex 开始行索引
     * @param lastIndex  结束行索引
     * @param <T>        列表类型
     */
    private static <T> void fillInSheetData(Sheet sheet, List<T> dataList, LinkedHashMap<String, ExcelField> fieldMap, int firstIndex, int lastIndex) {

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

        //填充表头
        Cell cell;
        Row row;

        row = sheet.createRow(0);
        for (int i = 0; i < cnFields.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(cnFields[i].getCnFieldName());
        }

        //填充内容
        String fieldValue;

        int rowNo = 1;
        for (int index = firstIndex; index <= lastIndex; index++) {

            //创建新行
            row = sheet.createRow(rowNo);

            //获取单个对象
            T item = dataList.get(index);
            Map<Object, Object> dataMap = DataConvertor.toMap(item);
            for (int i = 0; i < enFields.length; i++) {
                fieldValue = getFieldValueByName(dataMap, index, enFields[i], cnFields[i]);
                cell = row.createCell(i);
                cell.setCellValue(fieldValue);
            }

            rowNo++;
        }
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

    public static Row obtainRowAtIndex(Sheet sheet, Integer rowNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        return row;
    }

    public static Cell obtainCellAtIndex(Row row, Integer cellNum) {
        Cell cell = row.getCell(cellNum, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
        if (cell == null) {
            cell = row.createCell(cellNum);
        }
        return cell;
    }

    public static void makeHeader(Sheet sheet, List<HeaderRule> headerRuleList) {
        Cell cell;
        Row row;
        for (HeaderRule rule : headerRuleList) {
            row = obtainRowAtIndex(sheet, rule.getFirstRow());
            cell = obtainCellAtIndex(row, rule.getFirstColumn());
            cell.setCellValue(rule.getColumnName());
        }
    }
}

//package com.appledevapp.learning.excelexport.util;
//
//import com.appledevapp.learning.excelexport.entity.ExcelArea;
//import com.appledevapp.learning.excelexport.entity.ExcelConfig;
//import com.appledevapp.learning.excelexport.entity.ExcelField;
//import com.appledevapp.learning.excelexport.entity.HeaderRule;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 数据导出帮助类
// */
//public class DataExportorbak {
//
//    /**
//     * 每一页最大行数
//     */
//    public static final int MAX_SHEET_SIZE = 65535;
//
//    /**
//     * 导出数据为Excel到请求中
//     *
//     * @param fileName  文件名称,带拓展名
//     * @param dataList  数据列表
//     * @param fieldMap  字段映射字典
//     * @param sheetName Sheet名称
//     * @param sheetSize Sheet长度
//     * @param request   HTTP请求
//     * @param response  HTTP响应
//     * @param <T>       列表类型
//     * @throws IOException 异常
//     */
//    public static <T> void exportToExcel(String fileName, List<T> dataList, ExcelConfig excelConfig, LinkedHashMap<String, ExcelField> fieldMap, String sheetName, int sheetSize, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String userAgent = request.getHeader("USER-AGENT");
//        if (StringUtils.contains(userAgent, "MSIE")) {
//            //IE浏览器
//            fileName = URLEncoder.encode(fileName, "UTF8");
//        } else if (StringUtils.contains(userAgent, "Mozilla")) {
//            //google,火狐浏览器
//            fileName = new String(fileName.getBytes(), "ISO8859-1");
//        } else {
//            //其他浏览器
//            fileName = URLEncoder.encode(fileName, "UTF8");
//        }
//
//        response.setContentType("application/octet-stream;charset=utf-8");
//        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
//
//        ServletOutputStream servletOutputStream = response.getOutputStream();
//        exportToExcel(dataList, excelConfig, fieldMap, sheetName, sheetSize, servletOutputStream);
//        IOUtils.closeQuietly(servletOutputStream);
//    }
//
//    public static void exportToExcel(ExcelConfig excelConfig, OutputStream stream) throws IOException {
//
//        if (excelConfig == null) {
//            throw new IllegalArgumentException("Excel配置不能为NULL");
//        }
//
//        //创建和填充Excel
//        Workbook workbook = new XSSFWorkbook();
//
//        //判断Excel配置类型
//        if (excelConfig.getGroupType().equals(ExcelConfig.GroupType.PagerByNum)) {
//            subLayoutForPager(workbook, excelConfig);
//        } else {
//            subLayoutForGroup();
//        }
//
//        //把工作表写入到输出流
//        workbook.write(stream);
//        workbook.close();
//    }
//
//    private static void subLayoutForPager(Workbook workbook, ExcelConfig excelConfig) {
//        List<ExcelArea> areaList = excelConfig.getAreaList();
//        if (CollectionUtils.isEmpty(areaList) || areaList.size() > 1) {
//            throw new IllegalArgumentException("Excel分页只支持单区域");
//        }
//
//        //计算分页数
//        ExcelArea excelArea = areaList.get(0);
//        double sheetNum = Math.ceil(excelArea.getAreaDataList().size() / excelConfig.getPageSize().doubleValue());
//
//        Sheet sheet;
//        String sheetTabName;
//        int firstIndex;
//        int lastIndex;
//        int sheetSize = excelConfig.getPageSize();
//        List dataList = excelArea.getAreaDataList();
//        for (int i = 0; i < sheetNum; i++) {
//            //设置Sheet的底部名称
//            sheetTabName = sheetNum == 1 ? excelConfig.getSheetName() : excelConfig.getSheetName() + (i + 1);
//
//            sheet = workbook.createSheet(sheetTabName);
//
//            //是否需要设置列宽度
//            //sheet.setDefaultColumnWidth(20);
//
//            //获取开始索引和结束索引
//            firstIndex = i * sheetSize;
//            lastIndex = (i + 1) * sheetSize > dataList.size() ? dataList.size() - 1 : (i + 1) * sheetSize - 1;
//
//            //填充工作表
//            fillInSheetDataByPager(sheet, excelConfig, excelArea, firstIndex, lastIndex);
//        }
//    }
//
//    private static void subLayoutForGroup() {
//
//    }
//
//    /**
//     * 导出数据为Excel到请求中
//     *
//     * @param dataList  数据列表
//     * @param fieldMap  字段映射字典
//     * @param sheetName Sheet名称
//     * @param sheetSize Sheet长度
//     * @param <T>       列表类型
//     * @throws IOException 异常
//     */
//    public static <T> void exportToExcel(List<T> dataList, ExcelConfig excelConfig, LinkedHashMap<String, ExcelField> fieldMap, String sheetName, int sheetSize, OutputStream stream) throws IOException {
//
//        if (dataList == null) {
//            throw new IllegalArgumentException("列表数据不能为NULL");
//        }
//
//        //每一页数据能够存放多少条
//        if (sheetSize == -1) {
//            sheetSize = dataList.size();
//        } else {
//            if (sheetSize > MAX_SHEET_SIZE || sheetSize < 1) {
//                sheetSize = MAX_SHEET_SIZE;
//            }
//        }
//
//        //计算总数据需要区分多少页
//        double sheetNum = Math.ceil(dataList.size() / new Integer(sheetSize).doubleValue());
//
//        //创建和填充Excel
//        Workbook workbook = new XSSFWorkbook();
//
//        Sheet sheet;
//        String sheetTabName;
//        int firstIndex;
//        int lastIndex;
//        for (int i = 0; i < sheetNum; i++) {
//            //设置Sheet的底部名称
//            sheetTabName = sheetNum == 1 ? sheetName : sheetName + (i + 1);
//
//            sheet = workbook.createSheet(sheetTabName);
//
//            //是否需要设置列宽度
//            //sheet.setDefaultColumnWidth(20);
//
//            //获取开始索引和结束索引
//            firstIndex = i * sheetSize;
//            lastIndex = (i + 1) * sheetSize > dataList.size() ? dataList.size() - 1 : (i + 1) * sheetSize - 1;
//
//            //填充工作表
//            fillInSheetData(sheet, dataList, excelConfig, fieldMap, firstIndex, lastIndex);
//        }
//
//        //把工作表写入到输出流
//        workbook.write(stream);
//        workbook.close();
//    }
//
//    private static <T> List<CellRangeAddress> makeAreaHeader(Sheet sheet, ExcelArea<T> excelArea, int rowNo) {
//
//        //绘制表头
//        List<CellRangeAddress> mergerRuleList = new ArrayList<>();
//        if (CollectionUtils.isEmpty(excelArea.getHeaderRuleList())) {
//            return mergerRuleList;
//        }
//
//        Cell cell;
//        Row row;
//        for (HeaderRule rule : excelArea.getHeaderRuleList()) {
//            row = obtainRowAtIndex(sheet, rowNo + rule.getFirstRow());
//            cell = obtainCellAtIndex(row, rule.getFirstColumn());
//            cell.setCellValue(rule.getColumnName());
//            if (rule.isNeedMerge()) {
//                mergerRuleList.add(rule.buildRule(rowNo));
//            }
//        }
//
//        return mergerRuleList;
//    }
//
//    private static <T> void fillInSheetDataByPager(Sheet sheet, ExcelConfig excelConfig, ExcelArea<T> excelArea, int firstIndex, int lastIndex) {
//
//        //绘制表头
//        int rowNo = excelArea.getRowPaddingTop() - 1;
//        List<CellRangeAddress> mergerRuleList = makeAreaHeader(sheet, excelArea, rowNo);
//
//        LinkedHashMap<String, ExcelField> fieldMap = excelArea.getFieldMap();
//        //定义存放英文字段名和中文字段名的数组
//        String[] enFields = new String[fieldMap.size()];
//        ExcelField[] cnFields = new ExcelField[fieldMap.size()];
//
//        //填充字段映射数组
//        final int[] count = {0};
//        fieldMap.forEach((k, v) -> {
//            enFields[count[0]] = k;
//            cnFields[count[0]] = v;
//            count[0]++;
//        });
//
//        Cell cell;
//        Row row;
//
//        //填充内容
//        String fieldValue;
//
//        for (int index = firstIndex; index <= lastIndex; index++) {
//
//            //创建新行
//            row = obtainRowAtIndex(sheet, rowNo);
//
//            //获取单个对象
//            T item = excelArea.getAreaDataList().get(index);
//            Map<Object, Object> dataMap = DataConvertor.toMap(item);
//            for (int i = 0; i < enFields.length; i++) {
//                fieldValue = getFieldValueByName(dataMap, index, enFields[i], cnFields[i]);
//                cell = obtainCellAtIndex(row, i);
//                cell.setCellValue(fieldValue);
//            }
//
//            rowNo++;
//        }
//
//        //需要进行单元格合并
//        if (CollectionUtils.isNotEmpty(mergerRuleList)) {
//            for (CellRangeAddress mergeRule : mergerRuleList) {
//                sheet.addMergedRegion(mergeRule);
//            }
//        }
//    }
//
//
//    /**
//     * 填充数据方法
//     *
//     * @param sheet      Sheet表
//     * @param dataList   数据集
//     * @param fieldMap   字段映射
//     * @param firstIndex 开始行索引
//     * @param lastIndex  结束行索引
//     * @param <T>        列表类型
//     */
//    private static <T> void fillInSheetData(Sheet sheet, List<T> dataList, ExcelConfig excelConfig, LinkedHashMap<String, ExcelField> fieldMap, int firstIndex, int lastIndex) {
//
//        //定义存放英文字段名和中文字段名的数组
//        String[] enFields = new String[fieldMap.size()];
//        ExcelField[] cnFields = new ExcelField[fieldMap.size()];
//
//        //填充字段映射数组
//        final int[] count = {0};
//        fieldMap.forEach((k, v) -> {
//            enFields[count[0]] = k;
//            cnFields[count[0]] = v;
//            count[0]++;
//        });
//
//        //填充表头
//        List<CellRangeAddress> mergerRuleList = makeHeader(sheet, excelConfig.getHeaderRuleList());
//
//        Cell cell;
//        Row row;
//
//        /*
//        row = sheet.createRow(0);
//        for (int i = 0; i < cnFields.length; i++) {
//            cell = row.createCell(i);
//            cell.setCellValue(cnFields[i].getCnFieldName());
//        }
//        */
//
//        //填充内容
//        String fieldValue;
//
//        int rowNo = excelConfig.getFromRow();
//        for (int index = firstIndex; index <= lastIndex; index++) {
//
//            //创建新行
//            row = sheet.createRow(rowNo);
//
//            //获取单个对象
//            T item = dataList.get(index);
//            Map<Object, Object> dataMap = DataConvertor.toMap(item);
//            for (int i = 0; i < enFields.length; i++) {
//                fieldValue = getFieldValueByName(dataMap, index, enFields[i], cnFields[i]);
//                cell = row.createCell(i);
//                cell.setCellValue(fieldValue);
//            }
//
//            rowNo++;
//        }
//
//        //需要进行单元格合并
//        if (CollectionUtils.isNotEmpty(mergerRuleList)) {
//            for (CellRangeAddress mergeRule : mergerRuleList) {
//                sheet.addMergedRegion(mergeRule);
//            }
//        }
//    }
//
//    /**
//     * 获取字段值-应用函数转换
//     *
//     * @param dataMap    数据字典
//     * @param rowNum     行号
//     * @param fieldName  字段名称
//     * @param excelField Excel字段约束
//     * @return 转换为字符的值
//     */
//    private static String getFieldValueByName(Map<Object, Object> dataMap, Integer rowNum, String fieldName, ExcelField excelField) {
//        return excelField.applyFunc(dataMap, rowNum, fieldName);
//    }
//
//    public static Row obtainRowAtIndex(Sheet sheet, Integer rowNum) {
//        Row row = sheet.getRow(rowNum);
//        if (row == null) {
//            row = sheet.createRow(rowNum);
//        }
//        return row;
//    }
//
//    public static Cell obtainCellAtIndex(Row row, Integer cellNum) {
//        Cell cell = row.getCell(cellNum, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
//        if (cell == null) {
//            cell = row.createCell(cellNum);
//        }
//        return cell;
//    }
//
//    public static List<CellRangeAddress> makeHeader(Sheet sheet, List<HeaderRule> headerRuleList) {
//        List<CellRangeAddress> mergerRuleList = new ArrayList<>();
//        if (CollectionUtils.isEmpty(headerRuleList)) {
//            return mergerRuleList;
//        }
//
//        Cell cell;
//        Row row;
//        for (HeaderRule rule : headerRuleList) {
//            row = obtainRowAtIndex(sheet, rule.getFirstRow());
//            cell = obtainCellAtIndex(row, rule.getFirstColumn());
//            cell.setCellValue(rule.getColumnName());
//            if (rule.isNeedMerge()) {
//                mergerRuleList.add(rule.buildRule());
//            }
//        }
//
//        return mergerRuleList;
//    }
//}

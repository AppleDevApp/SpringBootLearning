package com.appledevapp.learning.excelexport.controller;

import com.appledevapp.learning.excelexport.entity.*;
import com.appledevapp.learning.excelexport.function.FormatFunc;
import com.appledevapp.learning.excelexport.util.DataExportor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@RestController
@RequestMapping("")
public class DataExportController {

    @RequestMapping("/")
    public String indexPage() {
        return "Hello";
    }

    @RequestMapping("export")
    public String exportData(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<MultiTypeEntity> dataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            MultiTypeEntity typeEntity = new MultiTypeEntity();
            typeEntity.setId((long) i);
            typeEntity.setAge(i + 1);
            typeEntity.setName("Hello" + i);
            typeEntity.setPayMoney(BigDecimal.valueOf(10.25 + i));
            typeEntity.setTimeDate(new Date());
            dataList.add(typeEntity);
        }

        List<MultiTypeEntity> dataTwoList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            MultiTypeEntity typeEntity = new MultiTypeEntity();
            typeEntity.setId((long) i);
            typeEntity.setAge(i + 1);
            typeEntity.setName("Hello Two" + i);
            typeEntity.setPayMoney(BigDecimal.valueOf(10.25 + i));
            typeEntity.setTimeDate(new Date());
            dataTwoList.add(typeEntity);
        }

        BiFunction<Map<Object, Object>, Integer, Object> rowFunc = (dataMap, rowNum) -> rowNum;

        Function<Object, String> ageFunc = (fieldValue) -> {
            Integer age = (Integer) fieldValue;
            return String.valueOf(age + 10);
        };

        //表格配置
        ExcelConfig config = new ExcelConfig(ExcelConfig.GroupType.GroupByData, 65535);
        //config.setPageSize(5);
        config.setSheetName("测试导出");

        //表格区域块
        ExcelArea excelArea = new ExcelArea();

        //配置表头
        List<String> columnNames = new ArrayList<>();
        columnNames.add("个人序号");
        columnNames.add("行号");
        columnNames.add("年龄");
        columnNames.add("名称");
        columnNames.add("格式时间");
        columnNames.add("金额(元)");

        List<HeaderRule> headerRuleList = HeaderRule.buildHeader(0, columnNames);

        //头部合并
        HeaderRule mergeRule = headerRuleList.get(0);
        mergeRule.setLastRow(1);
        mergeRule.setLastColumn(0);
        mergeRule.setNeedMerge(true);
        excelArea.setHeaderRuleList(headerRuleList);

        //数据列合并
        BiFunction<Map<Object, Object>, Integer, Boolean> vertifyFunc = (dataMap, rowNo) -> {
            return rowNo % 5 == 0;
        };

        BiFunction<Map<Object, Object>, Integer, CellRangeAddress> buildRuleFunc = (dataMap, rowNo) -> {
            return new CellRangeAddress(
                    rowNo,
                    rowNo + 2,
                    5,
                    5
            );
        };

        List<RowRule> rowRuleList = new ArrayList<>();
        RowRule rowRule = new RowRule(vertifyFunc, buildRuleFunc);
        rowRuleList.add(rowRule);

        //配置数据格式化
        LinkedHashMap<String, ExcelField> fieldMap = new LinkedHashMap<>();
        fieldMap.put("id", new ExcelField());
        fieldMap.put("rowNum", new ExcelField(rowFunc));
        fieldMap.put("age", new ExcelField(ageFunc));
        fieldMap.put("name", new ExcelField());
        fieldMap.put("timeDate", new ExcelField(FormatFunc.DATE_TIME_FORMAT));
        fieldMap.put("payMoney", new ExcelField(FormatFunc.DECIMAL_ONE_FORMAT));
        excelArea.setFieldMap(fieldMap);

        //配置列表数据
        excelArea.setAreaDataList(dataList);
        excelArea.setRowRuleList(rowRuleList);

        //写入配置到Config
        config.addArea(excelArea);

        String fileName = "标识.xlsx";
        DataExportor.exportToExcel(fileName, config, request, response);

        return "导出成功";
    }

}

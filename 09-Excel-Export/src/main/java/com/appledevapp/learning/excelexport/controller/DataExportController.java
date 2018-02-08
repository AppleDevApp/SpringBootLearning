package com.appledevapp.learning.excelexport.controller;

import com.appledevapp.learning.excelexport.entity.ExcelField;
import com.appledevapp.learning.excelexport.entity.MultiTypeEntity;
import com.appledevapp.learning.excelexport.function.FormatFunc;
import com.appledevapp.learning.excelexport.util.DataExportor;
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
        for (int i = 0; i < 10; i++) {
            MultiTypeEntity typeEntity = new MultiTypeEntity();
            typeEntity.setId((long) i);
            typeEntity.setAge(i + 1);
            typeEntity.setName("Hello" + i);
            typeEntity.setPayMoney(BigDecimal.valueOf(10.25 + i));
            typeEntity.setTimeDate(new Date());
            dataList.add(typeEntity);
        }

        BiFunction<Map<Object, Object>, Integer, Object> rowFunc = (dataMap, rowNum) -> rowNum;

        Function<Object, String> ageFunc = (fieldValue) -> {
            Integer age = (Integer) fieldValue;
            return String.valueOf(age + 10);
        };

        LinkedHashMap<String, ExcelField> fieldMap = new LinkedHashMap<>();
        fieldMap.put("id", new ExcelField("个人ID"));
        fieldMap.put("rowNum", new ExcelField("序号", rowFunc));
        fieldMap.put("age", new ExcelField("年龄", ageFunc));
        fieldMap.put("name", new ExcelField("名称"));
        fieldMap.put("timeDate", new ExcelField("时间", FormatFunc.DATE_TIME_FORMAT));
        fieldMap.put("payMoney", new ExcelField("金额", FormatFunc.DECIMAL_ONE_FORMAT));

        String fileName = "标识.xlsx";
        DataExportor.exportToExcel(fileName, dataList, fieldMap, "标识", 2, request, response);

        return "导出成功";
    }

}

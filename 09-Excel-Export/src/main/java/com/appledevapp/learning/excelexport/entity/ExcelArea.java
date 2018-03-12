package com.appledevapp.learning.excelexport.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Excel中每个数据块区域
 */
public class ExcelArea implements Serializable {

    private List<HeaderRule> headerRuleList;
    private List<RowRule> rowRuleList;
    private List areaDataList;
    private LinkedHashMap<String, ExcelField> fieldMap;
    private Integer areaPaddingTop;
    private Integer rowPaddingTop;

    public ExcelArea() {
        this.areaPaddingTop = 0;
        this.rowPaddingTop = 0;
    }

    public ExcelArea(int areaPaddingTop, int rowPaddingTop) {
        this.areaPaddingTop = areaPaddingTop;
        this.rowPaddingTop = rowPaddingTop;
    }

    public List<HeaderRule> getHeaderRuleList() {
        return headerRuleList;
    }

    public void setHeaderRuleList(List<HeaderRule> headerRuleList) {
        this.headerRuleList = headerRuleList;
    }

    public List<RowRule> getRowRuleList() {
        return rowRuleList;
    }

    public void setRowRuleList(List<RowRule> rowRuleList) {
        this.rowRuleList = rowRuleList;
    }

    public List getAreaDataList() {
        return areaDataList;
    }

    public void setAreaDataList(List areaDataList) {
        this.areaDataList = areaDataList;
    }

    public Integer getAreaPaddingTop() {
        return areaPaddingTop;
    }

    public void setAreaPaddingTop(Integer areaPaddingTop) {
        this.areaPaddingTop = areaPaddingTop;
    }

    public Integer getRowPaddingTop() {
        return rowPaddingTop;
    }

    public void setRowPaddingTop(Integer rowPaddingTop) {
        this.rowPaddingTop = rowPaddingTop;
    }

    public LinkedHashMap<String, ExcelField> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(LinkedHashMap<String, ExcelField> fieldMap) {
        this.fieldMap = fieldMap;
    }
}

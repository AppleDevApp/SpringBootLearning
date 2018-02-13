package com.appledevapp.learning.excelexport.entity;

import java.util.ArrayList;
import java.util.List;

public class ExcelConfig {

    /**
     * 每一页最大行数
     */
    public static final int MAX_SHEET_SIZE = 65535;

    private static final String SHEET_NAME = "数据导出";

    private List<ExcelArea> areaList;
    private GroupType groupType;
    private Integer pageSize;
    private String sheetName;

    public ExcelConfig() {
        this.groupType = GroupType.PagerByNum;
        this.pageSize = MAX_SHEET_SIZE;
        this.sheetName = SHEET_NAME;
        this.areaList = new ArrayList<>();
    }

    public ExcelConfig(GroupType groupType, int pageSize) {
        this.groupType = groupType;
        this.pageSize = pageSize;
        this.sheetName = SHEET_NAME;
        this.areaList = new ArrayList<>();
    }

    /**
     * 组别模式
     */
    public enum GroupType {
        /**
         * 分页模式，根据条数分页
         */
        PagerByNum,

        /**
         * 分组模式，根据数据类型区分
         */
        GroupByData
    }

    public List<ExcelArea> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<ExcelArea> areaList) {
        this.areaList = areaList;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void addArea(ExcelArea excelArea) {
        this.areaList.add(excelArea);
    }

}

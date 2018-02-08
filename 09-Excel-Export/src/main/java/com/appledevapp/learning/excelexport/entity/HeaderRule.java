package com.appledevapp.learning.excelexport.entity;

import org.apache.poi.ss.util.CellRangeAddress;

public class HeaderRule {

    private String columnName;
    private Integer firstRow;
    private Integer lastRow;
    private Integer firstColumn;
    private Integer lastColumn;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(Integer firstRow) {
        this.firstRow = firstRow;
    }

    public Integer getLastRow() {
        return lastRow;
    }

    public void setLastRow(Integer lastRow) {
        this.lastRow = lastRow;
    }

    public Integer getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(Integer firstColumn) {
        this.firstColumn = firstColumn;
    }

    public Integer getLastColumn() {
        return lastColumn;
    }

    public void setLastColumn(Integer lastColumn) {
        this.lastColumn = lastColumn;
    }

    public CellRangeAddress buildRule() {
        return new CellRangeAddress(this.getFirstRow(),
                this.getLastRow(),
                this.getFirstColumn(),
                this.getLastColumn()
        );
    }

}

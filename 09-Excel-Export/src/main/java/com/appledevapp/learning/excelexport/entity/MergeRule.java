package com.appledevapp.learning.excelexport.entity;

import java.io.Serializable;

public class MergeRule implements Serializable {

    private int firstRow;
    private int lastRow;
    private int firstColumn;
    private int lastColumn;
    private boolean isNeedMerge;

    public MergeRule() {
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public int getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(int firstColumn) {
        this.firstColumn = firstColumn;
    }

    public int getLastColumn() {
        return lastColumn;
    }

    public void setLastColumn(int lastColumn) {
        this.lastColumn = lastColumn;
    }

    public boolean isNeedMerge() {
        return isNeedMerge;
    }

    public void setNeedMerge(boolean needMerge) {
        isNeedMerge = needMerge;
    }
}

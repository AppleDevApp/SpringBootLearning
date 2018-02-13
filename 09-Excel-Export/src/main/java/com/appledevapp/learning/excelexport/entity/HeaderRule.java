package com.appledevapp.learning.excelexport.entity;

import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.List;

public class HeaderRule extends MergeRule {

    private String columnName;

    public HeaderRule(String columnName) {
        super();
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public CellRangeAddress buildRule(int rowPaddingTop) {
        return new CellRangeAddress(
                rowPaddingTop + this.getFirstRow(),
                rowPaddingTop + this.getLastRow(),
                this.getFirstColumn(),
                this.getLastColumn()
        );
    }

    public static List<HeaderRule> buildHeader(int firstRow, List<String> columnNames) {
        List<HeaderRule> headerRuleList = new ArrayList<>();
        HeaderRule headerRule;
        for (int i = 0, columnNamesSize = columnNames.size(); i < columnNamesSize; i++) {
            headerRule = new HeaderRule(columnNames.get(i));
            headerRule.setFirstRow(firstRow);
            headerRule.setFirstColumn(i);
            headerRuleList.add(headerRule);
        }
        return headerRuleList;
    }

}

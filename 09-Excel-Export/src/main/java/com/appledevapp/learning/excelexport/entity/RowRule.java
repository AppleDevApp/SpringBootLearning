package com.appledevapp.learning.excelexport.entity;

import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Map;
import java.util.function.BiFunction;

public class RowRule extends MergeRule {

    /**
     * 验证是否满足合并函数
     */
    private BiFunction<Map<Object, Object>, Integer, Boolean> vertifyFunc;
    private BiFunction<Map<Object, Object>, Integer, CellRangeAddress> buildRuleFunc;

    public RowRule(BiFunction<Map<Object, Object>, Integer, Boolean> vertifyFunc, BiFunction<Map<Object, Object>, Integer, CellRangeAddress> buildRuleFunc) {
        this.vertifyFunc = vertifyFunc;
        this.buildRuleFunc = buildRuleFunc;
    }

    public BiFunction<Map<Object, Object>, Integer, Boolean> getVertifyFunc() {
        return vertifyFunc;
    }

    public BiFunction<Map<Object, Object>, Integer, CellRangeAddress> getBuildRuleFunc() {
        return buildRuleFunc;
    }

    public boolean isNeedMerge(Map<Object, Object> dataMap, Integer rowNum) {
        if (this.vertifyFunc.apply(dataMap, rowNum)) {
            return true;
        }
        return false;
    }

    public CellRangeAddress buildRule(Map<Object, Object> dataMap, Integer rowNum) {
        return this.buildRuleFunc.apply(dataMap, rowNum);
    }
}

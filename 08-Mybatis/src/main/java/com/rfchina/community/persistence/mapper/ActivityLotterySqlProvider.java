package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ActivityLottery;
import com.rfchina.community.persistence.model.ActivityLotteryExample.Criteria;
import com.rfchina.community.persistence.model.ActivityLotteryExample.Criterion;
import com.rfchina.community.persistence.model.ActivityLotteryExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ActivityLotterySqlProvider {

    public String countByExample(ActivityLotteryExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("activity_lottery");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ActivityLotteryExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("activity_lottery");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ActivityLottery record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("activity_lottery");
        
        if (record.getActivityId() != null) {
            sql.VALUES("activity_id", "#{activityId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getIsWin() != null) {
            sql.VALUES("is_win", "#{isWin,jdbcType=TINYINT}");
        }
        
        if (record.getPrizeId() != null) {
            sql.VALUES("prize_id", "#{prizeId,jdbcType=BIGINT}");
        }
        
        if (record.getPrizeName() != null) {
            sql.VALUES("prize_name", "#{prizeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPrizeType() != null) {
            sql.VALUES("prize_type", "#{prizeType,jdbcType=TINYINT}");
        }
        
        if (record.getEleCodes() != null) {
            sql.VALUES("ele_codes", "#{eleCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getEleEndTime() != null) {
            sql.VALUES("ele_end_time", "#{eleEndTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.VALUES("send_status", "#{sendStatus,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsConfirm() != null) {
            sql.VALUES("is_confirm", "#{isConfirm,jdbcType=BIT}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.VALUES("confirm_time", "#{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPackageType() != null) {
            sql.VALUES("package_type", "#{packageType,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ActivityLotteryExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("activity_id");
        sql.SELECT("uid");
        sql.SELECT("name");
        sql.SELECT("phone");
        sql.SELECT("is_win");
        sql.SELECT("prize_id");
        sql.SELECT("prize_name");
        sql.SELECT("prize_type");
        sql.SELECT("ele_codes");
        sql.SELECT("ele_end_time");
        sql.SELECT("send_status");
        sql.SELECT("create_time");
        sql.SELECT("is_confirm");
        sql.SELECT("confirm_time");
        sql.SELECT("package_type");
        sql.FROM("activity_lottery");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ActivityLottery record = (ActivityLottery) parameter.get("record");
        ActivityLotteryExample example = (ActivityLotteryExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("activity_lottery");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getActivityId() != null) {
            sql.SET("activity_id = #{record.activityId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getIsWin() != null) {
            sql.SET("is_win = #{record.isWin,jdbcType=TINYINT}");
        }
        
        if (record.getPrizeId() != null) {
            sql.SET("prize_id = #{record.prizeId,jdbcType=BIGINT}");
        }
        
        if (record.getPrizeName() != null) {
            sql.SET("prize_name = #{record.prizeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPrizeType() != null) {
            sql.SET("prize_type = #{record.prizeType,jdbcType=TINYINT}");
        }
        
        if (record.getEleCodes() != null) {
            sql.SET("ele_codes = #{record.eleCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getEleEndTime() != null) {
            sql.SET("ele_end_time = #{record.eleEndTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.SET("send_status = #{record.sendStatus,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsConfirm() != null) {
            sql.SET("is_confirm = #{record.isConfirm,jdbcType=BIT}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.SET("confirm_time = #{record.confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPackageType() != null) {
            sql.SET("package_type = #{record.packageType,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("activity_lottery");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("activity_id = #{record.activityId,jdbcType=BIGINT}");
        sql.SET("uid = #{record.uid,jdbcType=BIGINT}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("is_win = #{record.isWin,jdbcType=TINYINT}");
        sql.SET("prize_id = #{record.prizeId,jdbcType=BIGINT}");
        sql.SET("prize_name = #{record.prizeName,jdbcType=VARCHAR}");
        sql.SET("prize_type = #{record.prizeType,jdbcType=TINYINT}");
        sql.SET("ele_codes = #{record.eleCodes,jdbcType=VARCHAR}");
        sql.SET("ele_end_time = #{record.eleEndTime,jdbcType=VARCHAR}");
        sql.SET("send_status = #{record.sendStatus,jdbcType=TINYINT}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("is_confirm = #{record.isConfirm,jdbcType=BIT}");
        sql.SET("confirm_time = #{record.confirmTime,jdbcType=TIMESTAMP}");
        sql.SET("package_type = #{record.packageType,jdbcType=INTEGER}");
        
        ActivityLotteryExample example = (ActivityLotteryExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ActivityLottery record) {
        SQL sql = new SQL();
        sql.UPDATE("activity_lottery");
        
        if (record.getActivityId() != null) {
            sql.SET("activity_id = #{activityId,jdbcType=BIGINT}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getIsWin() != null) {
            sql.SET("is_win = #{isWin,jdbcType=TINYINT}");
        }
        
        if (record.getPrizeId() != null) {
            sql.SET("prize_id = #{prizeId,jdbcType=BIGINT}");
        }
        
        if (record.getPrizeName() != null) {
            sql.SET("prize_name = #{prizeName,jdbcType=VARCHAR}");
        }
        
        if (record.getPrizeType() != null) {
            sql.SET("prize_type = #{prizeType,jdbcType=TINYINT}");
        }
        
        if (record.getEleCodes() != null) {
            sql.SET("ele_codes = #{eleCodes,jdbcType=VARCHAR}");
        }
        
        if (record.getEleEndTime() != null) {
            sql.SET("ele_end_time = #{eleEndTime,jdbcType=VARCHAR}");
        }
        
        if (record.getSendStatus() != null) {
            sql.SET("send_status = #{sendStatus,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsConfirm() != null) {
            sql.SET("is_confirm = #{isConfirm,jdbcType=BIT}");
        }
        
        if (record.getConfirmTime() != null) {
            sql.SET("confirm_time = #{confirmTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPackageType() != null) {
            sql.SET("package_type = #{packageType,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ActivityLotteryExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}
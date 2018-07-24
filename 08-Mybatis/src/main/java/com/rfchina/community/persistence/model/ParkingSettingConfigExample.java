package com.rfchina.community.persistence.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParkingSettingConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkingSettingConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCodeIdIsNull() {
            addCriterion("code_id is null");
            return (Criteria) this;
        }

        public Criteria andCodeIdIsNotNull() {
            addCriterion("code_id is not null");
            return (Criteria) this;
        }

        public Criteria andCodeIdEqualTo(Integer value) {
            addCriterion("code_id =", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdNotEqualTo(Integer value) {
            addCriterion("code_id <>", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdGreaterThan(Integer value) {
            addCriterion("code_id >", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("code_id >=", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdLessThan(Integer value) {
            addCriterion("code_id <", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("code_id <=", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdIn(List<Integer> values) {
            addCriterion("code_id in", values, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdNotIn(List<Integer> values) {
            addCriterion("code_id not in", values, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdBetween(Integer value1, Integer value2) {
            addCriterion("code_id between", value1, value2, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("code_id not between", value1, value2, "codeId");
            return (Criteria) this;
        }

        public Criteria andApiModeIsNull() {
            addCriterion("api_mode is null");
            return (Criteria) this;
        }

        public Criteria andApiModeIsNotNull() {
            addCriterion("api_mode is not null");
            return (Criteria) this;
        }

        public Criteria andApiModeEqualTo(Integer value) {
            addCriterion("api_mode =", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeNotEqualTo(Integer value) {
            addCriterion("api_mode <>", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeGreaterThan(Integer value) {
            addCriterion("api_mode >", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_mode >=", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeLessThan(Integer value) {
            addCriterion("api_mode <", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeLessThanOrEqualTo(Integer value) {
            addCriterion("api_mode <=", value, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeIn(List<Integer> values) {
            addCriterion("api_mode in", values, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeNotIn(List<Integer> values) {
            addCriterion("api_mode not in", values, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeBetween(Integer value1, Integer value2) {
            addCriterion("api_mode between", value1, value2, "apiMode");
            return (Criteria) this;
        }

        public Criteria andApiModeNotBetween(Integer value1, Integer value2) {
            addCriterion("api_mode not between", value1, value2, "apiMode");
            return (Criteria) this;
        }

        public Criteria andOpenShareIsNull() {
            addCriterion("open_share is null");
            return (Criteria) this;
        }

        public Criteria andOpenShareIsNotNull() {
            addCriterion("open_share is not null");
            return (Criteria) this;
        }

        public Criteria andOpenShareEqualTo(Integer value) {
            addCriterion("open_share =", value, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareNotEqualTo(Integer value) {
            addCriterion("open_share <>", value, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareGreaterThan(Integer value) {
            addCriterion("open_share >", value, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_share >=", value, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareLessThan(Integer value) {
            addCriterion("open_share <", value, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareLessThanOrEqualTo(Integer value) {
            addCriterion("open_share <=", value, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareIn(List<Integer> values) {
            addCriterion("open_share in", values, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareNotIn(List<Integer> values) {
            addCriterion("open_share not in", values, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareBetween(Integer value1, Integer value2) {
            addCriterion("open_share between", value1, value2, "openShare");
            return (Criteria) this;
        }

        public Criteria andOpenShareNotBetween(Integer value1, Integer value2) {
            addCriterion("open_share not between", value1, value2, "openShare");
            return (Criteria) this;
        }

        public Criteria andSharePriceIsNull() {
            addCriterion("share_price is null");
            return (Criteria) this;
        }

        public Criteria andSharePriceIsNotNull() {
            addCriterion("share_price is not null");
            return (Criteria) this;
        }

        public Criteria andSharePriceEqualTo(BigDecimal value) {
            addCriterion("share_price =", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceNotEqualTo(BigDecimal value) {
            addCriterion("share_price <>", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceGreaterThan(BigDecimal value) {
            addCriterion("share_price >", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("share_price >=", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceLessThan(BigDecimal value) {
            addCriterion("share_price <", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("share_price <=", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceIn(List<BigDecimal> values) {
            addCriterion("share_price in", values, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceNotIn(List<BigDecimal> values) {
            addCriterion("share_price not in", values, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_price between", value1, value2, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("share_price not between", value1, value2, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationIsNull() {
            addCriterion("share_free_duration is null");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationIsNotNull() {
            addCriterion("share_free_duration is not null");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationEqualTo(Long value) {
            addCriterion("share_free_duration =", value, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationNotEqualTo(Long value) {
            addCriterion("share_free_duration <>", value, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationGreaterThan(Long value) {
            addCriterion("share_free_duration >", value, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("share_free_duration >=", value, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationLessThan(Long value) {
            addCriterion("share_free_duration <", value, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationLessThanOrEqualTo(Long value) {
            addCriterion("share_free_duration <=", value, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationIn(List<Long> values) {
            addCriterion("share_free_duration in", values, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationNotIn(List<Long> values) {
            addCriterion("share_free_duration not in", values, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationBetween(Long value1, Long value2) {
            addCriterion("share_free_duration between", value1, value2, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andShareFreeDurationNotBetween(Long value1, Long value2) {
            addCriterion("share_free_duration not between", value1, value2, "shareFreeDuration");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceIsNull() {
            addCriterion("qrcode_price is null");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceIsNotNull() {
            addCriterion("qrcode_price is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceEqualTo(BigDecimal value) {
            addCriterion("qrcode_price =", value, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceNotEqualTo(BigDecimal value) {
            addCriterion("qrcode_price <>", value, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceGreaterThan(BigDecimal value) {
            addCriterion("qrcode_price >", value, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qrcode_price >=", value, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceLessThan(BigDecimal value) {
            addCriterion("qrcode_price <", value, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qrcode_price <=", value, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceIn(List<BigDecimal> values) {
            addCriterion("qrcode_price in", values, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceNotIn(List<BigDecimal> values) {
            addCriterion("qrcode_price not in", values, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qrcode_price between", value1, value2, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qrcode_price not between", value1, value2, "qrcodePrice");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationIsNull() {
            addCriterion("qrcode_free_duration is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationIsNotNull() {
            addCriterion("qrcode_free_duration is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationEqualTo(Long value) {
            addCriterion("qrcode_free_duration =", value, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationNotEqualTo(Long value) {
            addCriterion("qrcode_free_duration <>", value, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationGreaterThan(Long value) {
            addCriterion("qrcode_free_duration >", value, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("qrcode_free_duration >=", value, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationLessThan(Long value) {
            addCriterion("qrcode_free_duration <", value, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationLessThanOrEqualTo(Long value) {
            addCriterion("qrcode_free_duration <=", value, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationIn(List<Long> values) {
            addCriterion("qrcode_free_duration in", values, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationNotIn(List<Long> values) {
            addCriterion("qrcode_free_duration not in", values, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationBetween(Long value1, Long value2) {
            addCriterion("qrcode_free_duration between", value1, value2, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeFreeDurationNotBetween(Long value1, Long value2) {
            addCriterion("qrcode_free_duration not between", value1, value2, "qrcodeFreeDuration");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountIsNull() {
            addCriterion("qrcode_day_amount is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountIsNotNull() {
            addCriterion("qrcode_day_amount is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountEqualTo(BigDecimal value) {
            addCriterion("qrcode_day_amount =", value, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountNotEqualTo(BigDecimal value) {
            addCriterion("qrcode_day_amount <>", value, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountGreaterThan(BigDecimal value) {
            addCriterion("qrcode_day_amount >", value, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qrcode_day_amount >=", value, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountLessThan(BigDecimal value) {
            addCriterion("qrcode_day_amount <", value, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qrcode_day_amount <=", value, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountIn(List<BigDecimal> values) {
            addCriterion("qrcode_day_amount in", values, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountNotIn(List<BigDecimal> values) {
            addCriterion("qrcode_day_amount not in", values, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qrcode_day_amount between", value1, value2, "qrcodeDayAmount");
            return (Criteria) this;
        }

        public Criteria andQrcodeDayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qrcode_day_amount not between", value1, value2, "qrcodeDayAmount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
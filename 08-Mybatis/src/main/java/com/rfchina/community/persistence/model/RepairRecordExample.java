package com.rfchina.community.persistence.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIsNull() {
            addCriterion("master_child_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIsNotNull() {
            addCriterion("master_child_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdEqualTo(Long value) {
            addCriterion("master_child_id =", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotEqualTo(Long value) {
            addCriterion("master_child_id <>", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdGreaterThan(Long value) {
            addCriterion("master_child_id >", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdGreaterThanOrEqualTo(Long value) {
            addCriterion("master_child_id >=", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdLessThan(Long value) {
            addCriterion("master_child_id <", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdLessThanOrEqualTo(Long value) {
            addCriterion("master_child_id <=", value, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdIn(List<Long> values) {
            addCriterion("master_child_id in", values, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotIn(List<Long> values) {
            addCriterion("master_child_id not in", values, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdBetween(Long value1, Long value2) {
            addCriterion("master_child_id between", value1, value2, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andMasterChildIdNotBetween(Long value1, Long value2) {
            addCriterion("master_child_id not between", value1, value2, "masterChildId");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNull() {
            addCriterion("contact_mobile is null");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNotNull() {
            addCriterion("contact_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andContactMobileEqualTo(String value) {
            addCriterion("contact_mobile =", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotEqualTo(String value) {
            addCriterion("contact_mobile <>", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThan(String value) {
            addCriterion("contact_mobile >", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThanOrEqualTo(String value) {
            addCriterion("contact_mobile >=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThan(String value) {
            addCriterion("contact_mobile <", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThanOrEqualTo(String value) {
            addCriterion("contact_mobile <=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLike(String value) {
            addCriterion("contact_mobile like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotLike(String value) {
            addCriterion("contact_mobile not like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileIn(List<String> values) {
            addCriterion("contact_mobile in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotIn(List<String> values) {
            addCriterion("contact_mobile not in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileBetween(String value1, String value2) {
            addCriterion("contact_mobile between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotBetween(String value1, String value2) {
            addCriterion("contact_mobile not between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdIsNull() {
            addCriterion("problem_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdIsNotNull() {
            addCriterion("problem_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdEqualTo(Integer value) {
            addCriterion("problem_type_id =", value, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdNotEqualTo(Integer value) {
            addCriterion("problem_type_id <>", value, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdGreaterThan(Integer value) {
            addCriterion("problem_type_id >", value, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("problem_type_id >=", value, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdLessThan(Integer value) {
            addCriterion("problem_type_id <", value, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("problem_type_id <=", value, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdIn(List<Integer> values) {
            addCriterion("problem_type_id in", values, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdNotIn(List<Integer> values) {
            addCriterion("problem_type_id not in", values, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("problem_type_id between", value1, value2, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andProblemTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("problem_type_id not between", value1, value2, "problemTypeId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAttaIsNull() {
            addCriterion("atta is null");
            return (Criteria) this;
        }

        public Criteria andAttaIsNotNull() {
            addCriterion("atta is not null");
            return (Criteria) this;
        }

        public Criteria andAttaEqualTo(String value) {
            addCriterion("atta =", value, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaNotEqualTo(String value) {
            addCriterion("atta <>", value, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaGreaterThan(String value) {
            addCriterion("atta >", value, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaGreaterThanOrEqualTo(String value) {
            addCriterion("atta >=", value, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaLessThan(String value) {
            addCriterion("atta <", value, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaLessThanOrEqualTo(String value) {
            addCriterion("atta <=", value, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaLike(String value) {
            addCriterion("atta like", value, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaNotLike(String value) {
            addCriterion("atta not like", value, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaIn(List<String> values) {
            addCriterion("atta in", values, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaNotIn(List<String> values) {
            addCriterion("atta not in", values, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaBetween(String value1, String value2) {
            addCriterion("atta between", value1, value2, "atta");
            return (Criteria) this;
        }

        public Criteria andAttaNotBetween(String value1, String value2) {
            addCriterion("atta not between", value1, value2, "atta");
            return (Criteria) this;
        }

        public Criteria andRemimdIsNull() {
            addCriterion("remimd is null");
            return (Criteria) this;
        }

        public Criteria andRemimdIsNotNull() {
            addCriterion("remimd is not null");
            return (Criteria) this;
        }

        public Criteria andRemimdEqualTo(Integer value) {
            addCriterion("remimd =", value, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdNotEqualTo(Integer value) {
            addCriterion("remimd <>", value, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdGreaterThan(Integer value) {
            addCriterion("remimd >", value, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remimd >=", value, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdLessThan(Integer value) {
            addCriterion("remimd <", value, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdLessThanOrEqualTo(Integer value) {
            addCriterion("remimd <=", value, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdIn(List<Integer> values) {
            addCriterion("remimd in", values, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdNotIn(List<Integer> values) {
            addCriterion("remimd not in", values, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdBetween(Integer value1, Integer value2) {
            addCriterion("remimd between", value1, value2, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdNotBetween(Integer value1, Integer value2) {
            addCriterion("remimd not between", value1, value2, "remimd");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeIsNull() {
            addCriterion("remimd_time is null");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeIsNotNull() {
            addCriterion("remimd_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeEqualTo(Date value) {
            addCriterion("remimd_time =", value, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeNotEqualTo(Date value) {
            addCriterion("remimd_time <>", value, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeGreaterThan(Date value) {
            addCriterion("remimd_time >", value, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remimd_time >=", value, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeLessThan(Date value) {
            addCriterion("remimd_time <", value, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeLessThanOrEqualTo(Date value) {
            addCriterion("remimd_time <=", value, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeIn(List<Date> values) {
            addCriterion("remimd_time in", values, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeNotIn(List<Date> values) {
            addCriterion("remimd_time not in", values, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeBetween(Date value1, Date value2) {
            addCriterion("remimd_time between", value1, value2, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andRemimdTimeNotBetween(Date value1, Date value2) {
            addCriterion("remimd_time not between", value1, value2, "remimdTime");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreContentIsNull() {
            addCriterion("score_content is null");
            return (Criteria) this;
        }

        public Criteria andScoreContentIsNotNull() {
            addCriterion("score_content is not null");
            return (Criteria) this;
        }

        public Criteria andScoreContentEqualTo(String value) {
            addCriterion("score_content =", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentNotEqualTo(String value) {
            addCriterion("score_content <>", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentGreaterThan(String value) {
            addCriterion("score_content >", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentGreaterThanOrEqualTo(String value) {
            addCriterion("score_content >=", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentLessThan(String value) {
            addCriterion("score_content <", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentLessThanOrEqualTo(String value) {
            addCriterion("score_content <=", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentLike(String value) {
            addCriterion("score_content like", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentNotLike(String value) {
            addCriterion("score_content not like", value, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentIn(List<String> values) {
            addCriterion("score_content in", values, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentNotIn(List<String> values) {
            addCriterion("score_content not in", values, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentBetween(String value1, String value2) {
            addCriterion("score_content between", value1, value2, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreContentNotBetween(String value1, String value2) {
            addCriterion("score_content not between", value1, value2, "scoreContent");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIsNull() {
            addCriterion("score_time is null");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIsNotNull() {
            addCriterion("score_time is not null");
            return (Criteria) this;
        }

        public Criteria andScoreTimeEqualTo(Date value) {
            addCriterion("score_time =", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotEqualTo(Date value) {
            addCriterion("score_time <>", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeGreaterThan(Date value) {
            addCriterion("score_time >", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("score_time >=", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeLessThan(Date value) {
            addCriterion("score_time <", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeLessThanOrEqualTo(Date value) {
            addCriterion("score_time <=", value, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeIn(List<Date> values) {
            addCriterion("score_time in", values, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotIn(List<Date> values) {
            addCriterion("score_time not in", values, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeBetween(Date value1, Date value2) {
            addCriterion("score_time between", value1, value2, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andScoreTimeNotBetween(Date value1, Date value2) {
            addCriterion("score_time not between", value1, value2, "scoreTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andCommunityIdIsNull() {
            addCriterion("community_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(Integer value) {
            addCriterion("community_id =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(Integer value) {
            addCriterion("community_id <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(Integer value) {
            addCriterion("community_id >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_id >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(Integer value) {
            addCriterion("community_id <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(Integer value) {
            addCriterion("community_id <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<Integer> values) {
            addCriterion("community_id in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<Integer> values) {
            addCriterion("community_id not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(Integer value1, Integer value2) {
            addCriterion("community_id between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("community_id not between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFormTypeIsNull() {
            addCriterion("form_type is null");
            return (Criteria) this;
        }

        public Criteria andFormTypeIsNotNull() {
            addCriterion("form_type is not null");
            return (Criteria) this;
        }

        public Criteria andFormTypeEqualTo(Integer value) {
            addCriterion("form_type =", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotEqualTo(Integer value) {
            addCriterion("form_type <>", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeGreaterThan(Integer value) {
            addCriterion("form_type >", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("form_type >=", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeLessThan(Integer value) {
            addCriterion("form_type <", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeLessThanOrEqualTo(Integer value) {
            addCriterion("form_type <=", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeIn(List<Integer> values) {
            addCriterion("form_type in", values, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotIn(List<Integer> values) {
            addCriterion("form_type not in", values, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeBetween(Integer value1, Integer value2) {
            addCriterion("form_type between", value1, value2, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("form_type not between", value1, value2, "formType");
            return (Criteria) this;
        }

        public Criteria andOutReasonIsNull() {
            addCriterion("out_reason is null");
            return (Criteria) this;
        }

        public Criteria andOutReasonIsNotNull() {
            addCriterion("out_reason is not null");
            return (Criteria) this;
        }

        public Criteria andOutReasonEqualTo(String value) {
            addCriterion("out_reason =", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotEqualTo(String value) {
            addCriterion("out_reason <>", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonGreaterThan(String value) {
            addCriterion("out_reason >", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonGreaterThanOrEqualTo(String value) {
            addCriterion("out_reason >=", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLessThan(String value) {
            addCriterion("out_reason <", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLessThanOrEqualTo(String value) {
            addCriterion("out_reason <=", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonLike(String value) {
            addCriterion("out_reason like", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotLike(String value) {
            addCriterion("out_reason not like", value, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonIn(List<String> values) {
            addCriterion("out_reason in", values, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotIn(List<String> values) {
            addCriterion("out_reason not in", values, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonBetween(String value1, String value2) {
            addCriterion("out_reason between", value1, value2, "outReason");
            return (Criteria) this;
        }

        public Criteria andOutReasonNotBetween(String value1, String value2) {
            addCriterion("out_reason not between", value1, value2, "outReason");
            return (Criteria) this;
        }

        public Criteria andLabourFeeIsNull() {
            addCriterion("labour_fee is null");
            return (Criteria) this;
        }

        public Criteria andLabourFeeIsNotNull() {
            addCriterion("labour_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLabourFeeEqualTo(String value) {
            addCriterion("labour_fee =", value, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeNotEqualTo(String value) {
            addCriterion("labour_fee <>", value, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeGreaterThan(String value) {
            addCriterion("labour_fee >", value, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeGreaterThanOrEqualTo(String value) {
            addCriterion("labour_fee >=", value, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeLessThan(String value) {
            addCriterion("labour_fee <", value, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeLessThanOrEqualTo(String value) {
            addCriterion("labour_fee <=", value, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeLike(String value) {
            addCriterion("labour_fee like", value, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeNotLike(String value) {
            addCriterion("labour_fee not like", value, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeIn(List<String> values) {
            addCriterion("labour_fee in", values, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeNotIn(List<String> values) {
            addCriterion("labour_fee not in", values, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeBetween(String value1, String value2) {
            addCriterion("labour_fee between", value1, value2, "labourFee");
            return (Criteria) this;
        }

        public Criteria andLabourFeeNotBetween(String value1, String value2) {
            addCriterion("labour_fee not between", value1, value2, "labourFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeIsNull() {
            addCriterion("material_fee is null");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeIsNotNull() {
            addCriterion("material_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeEqualTo(String value) {
            addCriterion("material_fee =", value, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeNotEqualTo(String value) {
            addCriterion("material_fee <>", value, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeGreaterThan(String value) {
            addCriterion("material_fee >", value, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeGreaterThanOrEqualTo(String value) {
            addCriterion("material_fee >=", value, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeLessThan(String value) {
            addCriterion("material_fee <", value, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeLessThanOrEqualTo(String value) {
            addCriterion("material_fee <=", value, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeLike(String value) {
            addCriterion("material_fee like", value, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeNotLike(String value) {
            addCriterion("material_fee not like", value, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeIn(List<String> values) {
            addCriterion("material_fee in", values, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeNotIn(List<String> values) {
            addCriterion("material_fee not in", values, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeBetween(String value1, String value2) {
            addCriterion("material_fee between", value1, value2, "materialFee");
            return (Criteria) this;
        }

        public Criteria andMaterialFeeNotBetween(String value1, String value2) {
            addCriterion("material_fee not between", value1, value2, "materialFee");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIsNull() {
            addCriterion("service_category is null");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIsNotNull() {
            addCriterion("service_category is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryEqualTo(Integer value) {
            addCriterion("service_category =", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotEqualTo(Integer value) {
            addCriterion("service_category <>", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryGreaterThan(Integer value) {
            addCriterion("service_category >", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_category >=", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryLessThan(Integer value) {
            addCriterion("service_category <", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("service_category <=", value, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryIn(List<Integer> values) {
            addCriterion("service_category in", values, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotIn(List<Integer> values) {
            addCriterion("service_category not in", values, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryBetween(Integer value1, Integer value2) {
            addCriterion("service_category between", value1, value2, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andServiceCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("service_category not between", value1, value2, "serviceCategory");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelIsNull() {
            addCriterion("urgency_level is null");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelIsNotNull() {
            addCriterion("urgency_level is not null");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelEqualTo(Integer value) {
            addCriterion("urgency_level =", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelNotEqualTo(Integer value) {
            addCriterion("urgency_level <>", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelGreaterThan(Integer value) {
            addCriterion("urgency_level >", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("urgency_level >=", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelLessThan(Integer value) {
            addCriterion("urgency_level <", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelLessThanOrEqualTo(Integer value) {
            addCriterion("urgency_level <=", value, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelIn(List<Integer> values) {
            addCriterion("urgency_level in", values, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelNotIn(List<Integer> values) {
            addCriterion("urgency_level not in", values, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelBetween(Integer value1, Integer value2) {
            addCriterion("urgency_level between", value1, value2, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andUrgencyLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("urgency_level not between", value1, value2, "urgencyLevel");
            return (Criteria) this;
        }

        public Criteria andQualityTypeIsNull() {
            addCriterion("quality_type is null");
            return (Criteria) this;
        }

        public Criteria andQualityTypeIsNotNull() {
            addCriterion("quality_type is not null");
            return (Criteria) this;
        }

        public Criteria andQualityTypeEqualTo(Integer value) {
            addCriterion("quality_type =", value, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeNotEqualTo(Integer value) {
            addCriterion("quality_type <>", value, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeGreaterThan(Integer value) {
            addCriterion("quality_type >", value, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_type >=", value, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeLessThan(Integer value) {
            addCriterion("quality_type <", value, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("quality_type <=", value, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeIn(List<Integer> values) {
            addCriterion("quality_type in", values, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeNotIn(List<Integer> values) {
            addCriterion("quality_type not in", values, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeBetween(Integer value1, Integer value2) {
            addCriterion("quality_type between", value1, value2, "qualityType");
            return (Criteria) this;
        }

        public Criteria andQualityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_type not between", value1, value2, "qualityType");
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
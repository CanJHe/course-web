package com.canJ.pojo;

import java.util.ArrayList;
import java.util.List;

public class RemarkResponseTeaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RemarkResponseTeaExample() {
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

        public Criteria andResponseIdIsNull() {
            addCriterion("response_id is null");
            return (Criteria) this;
        }

        public Criteria andResponseIdIsNotNull() {
            addCriterion("response_id is not null");
            return (Criteria) this;
        }

        public Criteria andResponseIdEqualTo(Integer value) {
            addCriterion("response_id =", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotEqualTo(Integer value) {
            addCriterion("response_id <>", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdGreaterThan(Integer value) {
            addCriterion("response_id >", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("response_id >=", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdLessThan(Integer value) {
            addCriterion("response_id <", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdLessThanOrEqualTo(Integer value) {
            addCriterion("response_id <=", value, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdIn(List<Integer> values) {
            addCriterion("response_id in", values, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotIn(List<Integer> values) {
            addCriterion("response_id not in", values, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdBetween(Integer value1, Integer value2) {
            addCriterion("response_id between", value1, value2, "responseId");
            return (Criteria) this;
        }

        public Criteria andResponseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("response_id not between", value1, value2, "responseId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdIsNull() {
            addCriterion("remark_id is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIdIsNotNull() {
            addCriterion("remark_id is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkIdEqualTo(Integer value) {
            addCriterion("remark_id =", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdNotEqualTo(Integer value) {
            addCriterion("remark_id <>", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdGreaterThan(Integer value) {
            addCriterion("remark_id >", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("remark_id >=", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdLessThan(Integer value) {
            addCriterion("remark_id <", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdLessThanOrEqualTo(Integer value) {
            addCriterion("remark_id <=", value, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdIn(List<Integer> values) {
            addCriterion("remark_id in", values, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdNotIn(List<Integer> values) {
            addCriterion("remark_id not in", values, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdBetween(Integer value1, Integer value2) {
            addCriterion("remark_id between", value1, value2, "remarkId");
            return (Criteria) this;
        }

        public Criteria andRemarkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("remark_id not between", value1, value2, "remarkId");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("TeacherId is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("TeacherId is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("TeacherId =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("TeacherId <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("TeacherId >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("TeacherId >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("TeacherId <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("TeacherId <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("TeacherId in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("TeacherId not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("TeacherId between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("TeacherId not between", value1, value2, "teacherid");
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
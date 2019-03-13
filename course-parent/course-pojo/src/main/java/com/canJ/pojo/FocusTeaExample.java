package com.canJ.pojo;

import java.util.ArrayList;
import java.util.List;

public class FocusTeaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FocusTeaExample() {
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

        public Criteria andFocusidIsNull() {
            addCriterion("FocusId is null");
            return (Criteria) this;
        }

        public Criteria andFocusidIsNotNull() {
            addCriterion("FocusId is not null");
            return (Criteria) this;
        }

        public Criteria andFocusidEqualTo(Integer value) {
            addCriterion("FocusId =", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotEqualTo(Integer value) {
            addCriterion("FocusId <>", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidGreaterThan(Integer value) {
            addCriterion("FocusId >", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FocusId >=", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidLessThan(Integer value) {
            addCriterion("FocusId <", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidLessThanOrEqualTo(Integer value) {
            addCriterion("FocusId <=", value, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidIn(List<Integer> values) {
            addCriterion("FocusId in", values, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotIn(List<Integer> values) {
            addCriterion("FocusId not in", values, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidBetween(Integer value1, Integer value2) {
            addCriterion("FocusId between", value1, value2, "focusid");
            return (Criteria) this;
        }

        public Criteria andFocusidNotBetween(Integer value1, Integer value2) {
            addCriterion("FocusId not between", value1, value2, "focusid");
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

        public Criteria andOtherteacheridIsNull() {
            addCriterion("OtherTeacherId is null");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridIsNotNull() {
            addCriterion("OtherTeacherId is not null");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridEqualTo(Integer value) {
            addCriterion("OtherTeacherId =", value, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridNotEqualTo(Integer value) {
            addCriterion("OtherTeacherId <>", value, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridGreaterThan(Integer value) {
            addCriterion("OtherTeacherId >", value, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("OtherTeacherId >=", value, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridLessThan(Integer value) {
            addCriterion("OtherTeacherId <", value, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridLessThanOrEqualTo(Integer value) {
            addCriterion("OtherTeacherId <=", value, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridIn(List<Integer> values) {
            addCriterion("OtherTeacherId in", values, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridNotIn(List<Integer> values) {
            addCriterion("OtherTeacherId not in", values, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridBetween(Integer value1, Integer value2) {
            addCriterion("OtherTeacherId between", value1, value2, "otherteacherid");
            return (Criteria) this;
        }

        public Criteria andOtherteacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("OtherTeacherId not between", value1, value2, "otherteacherid");
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
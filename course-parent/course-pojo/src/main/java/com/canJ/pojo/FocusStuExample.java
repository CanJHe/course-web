package com.canJ.pojo;

import java.util.ArrayList;
import java.util.List;

public class FocusStuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FocusStuExample() {
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

        public Criteria andStudentidIsNull() {
            addCriterion("StudentId is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("StudentId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("StudentId =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("StudentId <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("StudentId >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("StudentId >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("StudentId <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("StudentId <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("StudentId in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("StudentId not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("StudentId between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("StudentId not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidIsNull() {
            addCriterion("OtherStudentId is null");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidIsNotNull() {
            addCriterion("OtherStudentId is not null");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidEqualTo(Integer value) {
            addCriterion("OtherStudentId =", value, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidNotEqualTo(Integer value) {
            addCriterion("OtherStudentId <>", value, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidGreaterThan(Integer value) {
            addCriterion("OtherStudentId >", value, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OtherStudentId >=", value, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidLessThan(Integer value) {
            addCriterion("OtherStudentId <", value, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidLessThanOrEqualTo(Integer value) {
            addCriterion("OtherStudentId <=", value, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidIn(List<Integer> values) {
            addCriterion("OtherStudentId in", values, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidNotIn(List<Integer> values) {
            addCriterion("OtherStudentId not in", values, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidBetween(Integer value1, Integer value2) {
            addCriterion("OtherStudentId between", value1, value2, "otherstudentid");
            return (Criteria) this;
        }

        public Criteria andOtherstudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("OtherStudentId not between", value1, value2, "otherstudentid");
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
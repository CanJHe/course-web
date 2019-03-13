package com.canJ.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionTeaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectionTeaExample() {
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

        public Criteria andCollectionidIsNull() {
            addCriterion("CollectionId is null");
            return (Criteria) this;
        }

        public Criteria andCollectionidIsNotNull() {
            addCriterion("CollectionId is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionidEqualTo(Integer value) {
            addCriterion("CollectionId =", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidNotEqualTo(Integer value) {
            addCriterion("CollectionId <>", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidGreaterThan(Integer value) {
            addCriterion("CollectionId >", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CollectionId >=", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidLessThan(Integer value) {
            addCriterion("CollectionId <", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidLessThanOrEqualTo(Integer value) {
            addCriterion("CollectionId <=", value, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidIn(List<Integer> values) {
            addCriterion("CollectionId in", values, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidNotIn(List<Integer> values) {
            addCriterion("CollectionId not in", values, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidBetween(Integer value1, Integer value2) {
            addCriterion("CollectionId between", value1, value2, "collectionid");
            return (Criteria) this;
        }

        public Criteria andCollectionidNotBetween(Integer value1, Integer value2) {
            addCriterion("CollectionId not between", value1, value2, "collectionid");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNull() {
            addCriterion("ResourceId is null");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNotNull() {
            addCriterion("ResourceId is not null");
            return (Criteria) this;
        }

        public Criteria andResourceidEqualTo(Integer value) {
            addCriterion("ResourceId =", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotEqualTo(Integer value) {
            addCriterion("ResourceId <>", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThan(Integer value) {
            addCriterion("ResourceId >", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ResourceId >=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThan(Integer value) {
            addCriterion("ResourceId <", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThanOrEqualTo(Integer value) {
            addCriterion("ResourceId <=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidIn(List<Integer> values) {
            addCriterion("ResourceId in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotIn(List<Integer> values) {
            addCriterion("ResourceId not in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidBetween(Integer value1, Integer value2) {
            addCriterion("ResourceId between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotBetween(Integer value1, Integer value2) {
            addCriterion("ResourceId not between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("Createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("Createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("Createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("Createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("Createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("Createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("Createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("Createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("Createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("Createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("Createtime not between", value1, value2, "createtime");
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
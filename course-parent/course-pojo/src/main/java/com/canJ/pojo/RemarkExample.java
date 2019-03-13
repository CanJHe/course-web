package com.canJ.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RemarkExample() {
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

        public Criteria andPostidTeaIsNull() {
            addCriterion("PostId_tea is null");
            return (Criteria) this;
        }

        public Criteria andPostidTeaIsNotNull() {
            addCriterion("PostId_tea is not null");
            return (Criteria) this;
        }

        public Criteria andPostidTeaEqualTo(Integer value) {
            addCriterion("PostId_tea =", value, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaNotEqualTo(Integer value) {
            addCriterion("PostId_tea <>", value, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaGreaterThan(Integer value) {
            addCriterion("PostId_tea >", value, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaGreaterThanOrEqualTo(Integer value) {
            addCriterion("PostId_tea >=", value, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaLessThan(Integer value) {
            addCriterion("PostId_tea <", value, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaLessThanOrEqualTo(Integer value) {
            addCriterion("PostId_tea <=", value, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaIn(List<Integer> values) {
            addCriterion("PostId_tea in", values, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaNotIn(List<Integer> values) {
            addCriterion("PostId_tea not in", values, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaBetween(Integer value1, Integer value2) {
            addCriterion("PostId_tea between", value1, value2, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidTeaNotBetween(Integer value1, Integer value2) {
            addCriterion("PostId_tea not between", value1, value2, "postidTea");
            return (Criteria) this;
        }

        public Criteria andPostidStuIsNull() {
            addCriterion("PostId_stu is null");
            return (Criteria) this;
        }

        public Criteria andPostidStuIsNotNull() {
            addCriterion("PostId_stu is not null");
            return (Criteria) this;
        }

        public Criteria andPostidStuEqualTo(Integer value) {
            addCriterion("PostId_stu =", value, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuNotEqualTo(Integer value) {
            addCriterion("PostId_stu <>", value, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuGreaterThan(Integer value) {
            addCriterion("PostId_stu >", value, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuGreaterThanOrEqualTo(Integer value) {
            addCriterion("PostId_stu >=", value, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuLessThan(Integer value) {
            addCriterion("PostId_stu <", value, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuLessThanOrEqualTo(Integer value) {
            addCriterion("PostId_stu <=", value, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuIn(List<Integer> values) {
            addCriterion("PostId_stu in", values, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuNotIn(List<Integer> values) {
            addCriterion("PostId_stu not in", values, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuBetween(Integer value1, Integer value2) {
            addCriterion("PostId_stu between", value1, value2, "postidStu");
            return (Criteria) this;
        }

        public Criteria andPostidStuNotBetween(Integer value1, Integer value2) {
            addCriterion("PostId_stu not between", value1, value2, "postidStu");
            return (Criteria) this;
        }

        public Criteria andRemarkContextIsNull() {
            addCriterion("remark_context is null");
            return (Criteria) this;
        }

        public Criteria andRemarkContextIsNotNull() {
            addCriterion("remark_context is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkContextEqualTo(String value) {
            addCriterion("remark_context =", value, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextNotEqualTo(String value) {
            addCriterion("remark_context <>", value, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextGreaterThan(String value) {
            addCriterion("remark_context >", value, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextGreaterThanOrEqualTo(String value) {
            addCriterion("remark_context >=", value, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextLessThan(String value) {
            addCriterion("remark_context <", value, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextLessThanOrEqualTo(String value) {
            addCriterion("remark_context <=", value, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextLike(String value) {
            addCriterion("remark_context like", value, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextNotLike(String value) {
            addCriterion("remark_context not like", value, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextIn(List<String> values) {
            addCriterion("remark_context in", values, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextNotIn(List<String> values) {
            addCriterion("remark_context not in", values, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextBetween(String value1, String value2) {
            addCriterion("remark_context between", value1, value2, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkContextNotBetween(String value1, String value2) {
            addCriterion("remark_context not between", value1, value2, "remarkContext");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeIsNull() {
            addCriterion("remark_time is null");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeIsNotNull() {
            addCriterion("remark_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeEqualTo(Date value) {
            addCriterion("remark_time =", value, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeNotEqualTo(Date value) {
            addCriterion("remark_time <>", value, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeGreaterThan(Date value) {
            addCriterion("remark_time >", value, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remark_time >=", value, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeLessThan(Date value) {
            addCriterion("remark_time <", value, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeLessThanOrEqualTo(Date value) {
            addCriterion("remark_time <=", value, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeIn(List<Date> values) {
            addCriterion("remark_time in", values, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeNotIn(List<Date> values) {
            addCriterion("remark_time not in", values, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeBetween(Date value1, Date value2) {
            addCriterion("remark_time between", value1, value2, "remarkTime");
            return (Criteria) this;
        }

        public Criteria andRemarkTimeNotBetween(Date value1, Date value2) {
            addCriterion("remark_time not between", value1, value2, "remarkTime");
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
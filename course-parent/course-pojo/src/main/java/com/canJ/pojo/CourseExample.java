package com.canJ.pojo;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCouridIsNull() {
            addCriterion("courId is null");
            return (Criteria) this;
        }

        public Criteria andCouridIsNotNull() {
            addCriterion("courId is not null");
            return (Criteria) this;
        }

        public Criteria andCouridEqualTo(Integer value) {
            addCriterion("courId =", value, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridNotEqualTo(Integer value) {
            addCriterion("courId <>", value, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridGreaterThan(Integer value) {
            addCriterion("courId >", value, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridGreaterThanOrEqualTo(Integer value) {
            addCriterion("courId >=", value, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridLessThan(Integer value) {
            addCriterion("courId <", value, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridLessThanOrEqualTo(Integer value) {
            addCriterion("courId <=", value, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridIn(List<Integer> values) {
            addCriterion("courId in", values, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridNotIn(List<Integer> values) {
            addCriterion("courId not in", values, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridBetween(Integer value1, Integer value2) {
            addCriterion("courId between", value1, value2, "courid");
            return (Criteria) this;
        }

        public Criteria andCouridNotBetween(Integer value1, Integer value2) {
            addCriterion("courId not between", value1, value2, "courid");
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

        public Criteria andCournumberIsNull() {
            addCriterion("courNumber is null");
            return (Criteria) this;
        }

        public Criteria andCournumberIsNotNull() {
            addCriterion("courNumber is not null");
            return (Criteria) this;
        }

        public Criteria andCournumberEqualTo(String value) {
            addCriterion("courNumber =", value, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberNotEqualTo(String value) {
            addCriterion("courNumber <>", value, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberGreaterThan(String value) {
            addCriterion("courNumber >", value, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberGreaterThanOrEqualTo(String value) {
            addCriterion("courNumber >=", value, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberLessThan(String value) {
            addCriterion("courNumber <", value, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberLessThanOrEqualTo(String value) {
            addCriterion("courNumber <=", value, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberLike(String value) {
            addCriterion("courNumber like", value, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberNotLike(String value) {
            addCriterion("courNumber not like", value, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberIn(List<String> values) {
            addCriterion("courNumber in", values, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberNotIn(List<String> values) {
            addCriterion("courNumber not in", values, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberBetween(String value1, String value2) {
            addCriterion("courNumber between", value1, value2, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournumberNotBetween(String value1, String value2) {
            addCriterion("courNumber not between", value1, value2, "cournumber");
            return (Criteria) this;
        }

        public Criteria andCournameIsNull() {
            addCriterion("courName is null");
            return (Criteria) this;
        }

        public Criteria andCournameIsNotNull() {
            addCriterion("courName is not null");
            return (Criteria) this;
        }

        public Criteria andCournameEqualTo(String value) {
            addCriterion("courName =", value, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameNotEqualTo(String value) {
            addCriterion("courName <>", value, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameGreaterThan(String value) {
            addCriterion("courName >", value, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameGreaterThanOrEqualTo(String value) {
            addCriterion("courName >=", value, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameLessThan(String value) {
            addCriterion("courName <", value, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameLessThanOrEqualTo(String value) {
            addCriterion("courName <=", value, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameLike(String value) {
            addCriterion("courName like", value, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameNotLike(String value) {
            addCriterion("courName not like", value, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameIn(List<String> values) {
            addCriterion("courName in", values, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameNotIn(List<String> values) {
            addCriterion("courName not in", values, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameBetween(String value1, String value2) {
            addCriterion("courName between", value1, value2, "courname");
            return (Criteria) this;
        }

        public Criteria andCournameNotBetween(String value1, String value2) {
            addCriterion("courName not between", value1, value2, "courname");
            return (Criteria) this;
        }

        public Criteria andCourcreditIsNull() {
            addCriterion("courCredit is null");
            return (Criteria) this;
        }

        public Criteria andCourcreditIsNotNull() {
            addCriterion("courCredit is not null");
            return (Criteria) this;
        }

        public Criteria andCourcreditEqualTo(Integer value) {
            addCriterion("courCredit =", value, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditNotEqualTo(Integer value) {
            addCriterion("courCredit <>", value, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditGreaterThan(Integer value) {
            addCriterion("courCredit >", value, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("courCredit >=", value, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditLessThan(Integer value) {
            addCriterion("courCredit <", value, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditLessThanOrEqualTo(Integer value) {
            addCriterion("courCredit <=", value, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditIn(List<Integer> values) {
            addCriterion("courCredit in", values, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditNotIn(List<Integer> values) {
            addCriterion("courCredit not in", values, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditBetween(Integer value1, Integer value2) {
            addCriterion("courCredit between", value1, value2, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourcreditNotBetween(Integer value1, Integer value2) {
            addCriterion("courCredit not between", value1, value2, "courcredit");
            return (Criteria) this;
        }

        public Criteria andCourgradeIsNull() {
            addCriterion("courGrade is null");
            return (Criteria) this;
        }

        public Criteria andCourgradeIsNotNull() {
            addCriterion("courGrade is not null");
            return (Criteria) this;
        }

        public Criteria andCourgradeEqualTo(Integer value) {
            addCriterion("courGrade =", value, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeNotEqualTo(Integer value) {
            addCriterion("courGrade <>", value, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeGreaterThan(Integer value) {
            addCriterion("courGrade >", value, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("courGrade >=", value, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeLessThan(Integer value) {
            addCriterion("courGrade <", value, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeLessThanOrEqualTo(Integer value) {
            addCriterion("courGrade <=", value, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeIn(List<Integer> values) {
            addCriterion("courGrade in", values, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeNotIn(List<Integer> values) {
            addCriterion("courGrade not in", values, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeBetween(Integer value1, Integer value2) {
            addCriterion("courGrade between", value1, value2, "courgrade");
            return (Criteria) this;
        }

        public Criteria andCourgradeNotBetween(Integer value1, Integer value2) {
            addCriterion("courGrade not between", value1, value2, "courgrade");
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
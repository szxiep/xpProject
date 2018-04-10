package com.astrology.na.entity;

import java.util.ArrayList;
import java.util.List;

public class AstRuleListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AstRuleListExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andRule1IsNull() {
            addCriterion("rule1 is null");
            return (Criteria) this;
        }

        public Criteria andRule1IsNotNull() {
            addCriterion("rule1 is not null");
            return (Criteria) this;
        }

        public Criteria andRule1EqualTo(Integer value) {
            addCriterion("rule1 =", value, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1NotEqualTo(Integer value) {
            addCriterion("rule1 <>", value, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1GreaterThan(Integer value) {
            addCriterion("rule1 >", value, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1GreaterThanOrEqualTo(Integer value) {
            addCriterion("rule1 >=", value, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1LessThan(Integer value) {
            addCriterion("rule1 <", value, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1LessThanOrEqualTo(Integer value) {
            addCriterion("rule1 <=", value, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1In(List<Integer> values) {
            addCriterion("rule1 in", values, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1NotIn(List<Integer> values) {
            addCriterion("rule1 not in", values, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1Between(Integer value1, Integer value2) {
            addCriterion("rule1 between", value1, value2, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule1NotBetween(Integer value1, Integer value2) {
            addCriterion("rule1 not between", value1, value2, "rule1");
            return (Criteria) this;
        }

        public Criteria andRule2IsNull() {
            addCriterion("rule2 is null");
            return (Criteria) this;
        }

        public Criteria andRule2IsNotNull() {
            addCriterion("rule2 is not null");
            return (Criteria) this;
        }

        public Criteria andRule2EqualTo(Integer value) {
            addCriterion("rule2 =", value, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2NotEqualTo(Integer value) {
            addCriterion("rule2 <>", value, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2GreaterThan(Integer value) {
            addCriterion("rule2 >", value, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2GreaterThanOrEqualTo(Integer value) {
            addCriterion("rule2 >=", value, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2LessThan(Integer value) {
            addCriterion("rule2 <", value, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2LessThanOrEqualTo(Integer value) {
            addCriterion("rule2 <=", value, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2In(List<Integer> values) {
            addCriterion("rule2 in", values, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2NotIn(List<Integer> values) {
            addCriterion("rule2 not in", values, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2Between(Integer value1, Integer value2) {
            addCriterion("rule2 between", value1, value2, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule2NotBetween(Integer value1, Integer value2) {
            addCriterion("rule2 not between", value1, value2, "rule2");
            return (Criteria) this;
        }

        public Criteria andRule3IsNull() {
            addCriterion("rule3 is null");
            return (Criteria) this;
        }

        public Criteria andRule3IsNotNull() {
            addCriterion("rule3 is not null");
            return (Criteria) this;
        }

        public Criteria andRule3EqualTo(Integer value) {
            addCriterion("rule3 =", value, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3NotEqualTo(Integer value) {
            addCriterion("rule3 <>", value, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3GreaterThan(Integer value) {
            addCriterion("rule3 >", value, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3GreaterThanOrEqualTo(Integer value) {
            addCriterion("rule3 >=", value, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3LessThan(Integer value) {
            addCriterion("rule3 <", value, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3LessThanOrEqualTo(Integer value) {
            addCriterion("rule3 <=", value, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3In(List<Integer> values) {
            addCriterion("rule3 in", values, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3NotIn(List<Integer> values) {
            addCriterion("rule3 not in", values, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3Between(Integer value1, Integer value2) {
            addCriterion("rule3 between", value1, value2, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule3NotBetween(Integer value1, Integer value2) {
            addCriterion("rule3 not between", value1, value2, "rule3");
            return (Criteria) this;
        }

        public Criteria andRule4IsNull() {
            addCriterion("rule4 is null");
            return (Criteria) this;
        }

        public Criteria andRule4IsNotNull() {
            addCriterion("rule4 is not null");
            return (Criteria) this;
        }

        public Criteria andRule4EqualTo(String value) {
            addCriterion("rule4 =", value, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4NotEqualTo(String value) {
            addCriterion("rule4 <>", value, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4GreaterThan(String value) {
            addCriterion("rule4 >", value, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4GreaterThanOrEqualTo(String value) {
            addCriterion("rule4 >=", value, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4LessThan(String value) {
            addCriterion("rule4 <", value, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4LessThanOrEqualTo(String value) {
            addCriterion("rule4 <=", value, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4Like(String value) {
            addCriterion("rule4 like", value, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4NotLike(String value) {
            addCriterion("rule4 not like", value, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4In(List<String> values) {
            addCriterion("rule4 in", values, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4NotIn(List<String> values) {
            addCriterion("rule4 not in", values, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4Between(String value1, String value2) {
            addCriterion("rule4 between", value1, value2, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule4NotBetween(String value1, String value2) {
            addCriterion("rule4 not between", value1, value2, "rule4");
            return (Criteria) this;
        }

        public Criteria andRule5IsNull() {
            addCriterion("rule5 is null");
            return (Criteria) this;
        }

        public Criteria andRule5IsNotNull() {
            addCriterion("rule5 is not null");
            return (Criteria) this;
        }

        public Criteria andRule5EqualTo(String value) {
            addCriterion("rule5 =", value, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5NotEqualTo(String value) {
            addCriterion("rule5 <>", value, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5GreaterThan(String value) {
            addCriterion("rule5 >", value, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5GreaterThanOrEqualTo(String value) {
            addCriterion("rule5 >=", value, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5LessThan(String value) {
            addCriterion("rule5 <", value, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5LessThanOrEqualTo(String value) {
            addCriterion("rule5 <=", value, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5Like(String value) {
            addCriterion("rule5 like", value, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5NotLike(String value) {
            addCriterion("rule5 not like", value, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5In(List<String> values) {
            addCriterion("rule5 in", values, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5NotIn(List<String> values) {
            addCriterion("rule5 not in", values, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5Between(String value1, String value2) {
            addCriterion("rule5 between", value1, value2, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule5NotBetween(String value1, String value2) {
            addCriterion("rule5 not between", value1, value2, "rule5");
            return (Criteria) this;
        }

        public Criteria andRule6IsNull() {
            addCriterion("rule6 is null");
            return (Criteria) this;
        }

        public Criteria andRule6IsNotNull() {
            addCriterion("rule6 is not null");
            return (Criteria) this;
        }

        public Criteria andRule6EqualTo(Integer value) {
            addCriterion("rule6 =", value, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6NotEqualTo(Integer value) {
            addCriterion("rule6 <>", value, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6GreaterThan(Integer value) {
            addCriterion("rule6 >", value, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6GreaterThanOrEqualTo(Integer value) {
            addCriterion("rule6 >=", value, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6LessThan(Integer value) {
            addCriterion("rule6 <", value, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6LessThanOrEqualTo(Integer value) {
            addCriterion("rule6 <=", value, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6In(List<Integer> values) {
            addCriterion("rule6 in", values, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6NotIn(List<Integer> values) {
            addCriterion("rule6 not in", values, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6Between(Integer value1, Integer value2) {
            addCriterion("rule6 between", value1, value2, "rule6");
            return (Criteria) this;
        }

        public Criteria andRule6NotBetween(Integer value1, Integer value2) {
            addCriterion("rule6 not between", value1, value2, "rule6");
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
    }

    /**
     */
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
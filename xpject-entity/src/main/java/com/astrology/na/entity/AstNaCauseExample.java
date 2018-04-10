package com.astrology.na.entity;

import java.util.ArrayList;
import java.util.List;

public class AstNaCauseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AstNaCauseExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCy1IsNull() {
            addCriterion("cy1 is null");
            return (Criteria) this;
        }

        public Criteria andCy1IsNotNull() {
            addCriterion("cy1 is not null");
            return (Criteria) this;
        }

        public Criteria andCy1EqualTo(String value) {
            addCriterion("cy1 =", value, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1NotEqualTo(String value) {
            addCriterion("cy1 <>", value, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1GreaterThan(String value) {
            addCriterion("cy1 >", value, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1GreaterThanOrEqualTo(String value) {
            addCriterion("cy1 >=", value, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1LessThan(String value) {
            addCriterion("cy1 <", value, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1LessThanOrEqualTo(String value) {
            addCriterion("cy1 <=", value, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1Like(String value) {
            addCriterion("cy1 like", value, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1NotLike(String value) {
            addCriterion("cy1 not like", value, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1In(List<String> values) {
            addCriterion("cy1 in", values, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1NotIn(List<String> values) {
            addCriterion("cy1 not in", values, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1Between(String value1, String value2) {
            addCriterion("cy1 between", value1, value2, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy1NotBetween(String value1, String value2) {
            addCriterion("cy1 not between", value1, value2, "cy1");
            return (Criteria) this;
        }

        public Criteria andCy2IsNull() {
            addCriterion("cy2 is null");
            return (Criteria) this;
        }

        public Criteria andCy2IsNotNull() {
            addCriterion("cy2 is not null");
            return (Criteria) this;
        }

        public Criteria andCy2EqualTo(String value) {
            addCriterion("cy2 =", value, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2NotEqualTo(String value) {
            addCriterion("cy2 <>", value, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2GreaterThan(String value) {
            addCriterion("cy2 >", value, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2GreaterThanOrEqualTo(String value) {
            addCriterion("cy2 >=", value, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2LessThan(String value) {
            addCriterion("cy2 <", value, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2LessThanOrEqualTo(String value) {
            addCriterion("cy2 <=", value, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2Like(String value) {
            addCriterion("cy2 like", value, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2NotLike(String value) {
            addCriterion("cy2 not like", value, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2In(List<String> values) {
            addCriterion("cy2 in", values, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2NotIn(List<String> values) {
            addCriterion("cy2 not in", values, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2Between(String value1, String value2) {
            addCriterion("cy2 between", value1, value2, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy2NotBetween(String value1, String value2) {
            addCriterion("cy2 not between", value1, value2, "cy2");
            return (Criteria) this;
        }

        public Criteria andCy3IsNull() {
            addCriterion("cy3 is null");
            return (Criteria) this;
        }

        public Criteria andCy3IsNotNull() {
            addCriterion("cy3 is not null");
            return (Criteria) this;
        }

        public Criteria andCy3EqualTo(String value) {
            addCriterion("cy3 =", value, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3NotEqualTo(String value) {
            addCriterion("cy3 <>", value, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3GreaterThan(String value) {
            addCriterion("cy3 >", value, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3GreaterThanOrEqualTo(String value) {
            addCriterion("cy3 >=", value, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3LessThan(String value) {
            addCriterion("cy3 <", value, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3LessThanOrEqualTo(String value) {
            addCriterion("cy3 <=", value, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3Like(String value) {
            addCriterion("cy3 like", value, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3NotLike(String value) {
            addCriterion("cy3 not like", value, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3In(List<String> values) {
            addCriterion("cy3 in", values, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3NotIn(List<String> values) {
            addCriterion("cy3 not in", values, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3Between(String value1, String value2) {
            addCriterion("cy3 between", value1, value2, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy3NotBetween(String value1, String value2) {
            addCriterion("cy3 not between", value1, value2, "cy3");
            return (Criteria) this;
        }

        public Criteria andCy4IsNull() {
            addCriterion("cy4 is null");
            return (Criteria) this;
        }

        public Criteria andCy4IsNotNull() {
            addCriterion("cy4 is not null");
            return (Criteria) this;
        }

        public Criteria andCy4EqualTo(String value) {
            addCriterion("cy4 =", value, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4NotEqualTo(String value) {
            addCriterion("cy4 <>", value, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4GreaterThan(String value) {
            addCriterion("cy4 >", value, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4GreaterThanOrEqualTo(String value) {
            addCriterion("cy4 >=", value, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4LessThan(String value) {
            addCriterion("cy4 <", value, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4LessThanOrEqualTo(String value) {
            addCriterion("cy4 <=", value, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4Like(String value) {
            addCriterion("cy4 like", value, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4NotLike(String value) {
            addCriterion("cy4 not like", value, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4In(List<String> values) {
            addCriterion("cy4 in", values, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4NotIn(List<String> values) {
            addCriterion("cy4 not in", values, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4Between(String value1, String value2) {
            addCriterion("cy4 between", value1, value2, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy4NotBetween(String value1, String value2) {
            addCriterion("cy4 not between", value1, value2, "cy4");
            return (Criteria) this;
        }

        public Criteria andCy5IsNull() {
            addCriterion("cy5 is null");
            return (Criteria) this;
        }

        public Criteria andCy5IsNotNull() {
            addCriterion("cy5 is not null");
            return (Criteria) this;
        }

        public Criteria andCy5EqualTo(String value) {
            addCriterion("cy5 =", value, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5NotEqualTo(String value) {
            addCriterion("cy5 <>", value, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5GreaterThan(String value) {
            addCriterion("cy5 >", value, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5GreaterThanOrEqualTo(String value) {
            addCriterion("cy5 >=", value, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5LessThan(String value) {
            addCriterion("cy5 <", value, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5LessThanOrEqualTo(String value) {
            addCriterion("cy5 <=", value, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5Like(String value) {
            addCriterion("cy5 like", value, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5NotLike(String value) {
            addCriterion("cy5 not like", value, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5In(List<String> values) {
            addCriterion("cy5 in", values, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5NotIn(List<String> values) {
            addCriterion("cy5 not in", values, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5Between(String value1, String value2) {
            addCriterion("cy5 between", value1, value2, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy5NotBetween(String value1, String value2) {
            addCriterion("cy5 not between", value1, value2, "cy5");
            return (Criteria) this;
        }

        public Criteria andCy6IsNull() {
            addCriterion("cy6 is null");
            return (Criteria) this;
        }

        public Criteria andCy6IsNotNull() {
            addCriterion("cy6 is not null");
            return (Criteria) this;
        }

        public Criteria andCy6EqualTo(String value) {
            addCriterion("cy6 =", value, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6NotEqualTo(String value) {
            addCriterion("cy6 <>", value, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6GreaterThan(String value) {
            addCriterion("cy6 >", value, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6GreaterThanOrEqualTo(String value) {
            addCriterion("cy6 >=", value, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6LessThan(String value) {
            addCriterion("cy6 <", value, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6LessThanOrEqualTo(String value) {
            addCriterion("cy6 <=", value, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6Like(String value) {
            addCriterion("cy6 like", value, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6NotLike(String value) {
            addCriterion("cy6 not like", value, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6In(List<String> values) {
            addCriterion("cy6 in", values, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6NotIn(List<String> values) {
            addCriterion("cy6 not in", values, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6Between(String value1, String value2) {
            addCriterion("cy6 between", value1, value2, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy6NotBetween(String value1, String value2) {
            addCriterion("cy6 not between", value1, value2, "cy6");
            return (Criteria) this;
        }

        public Criteria andCy7IsNull() {
            addCriterion("cy7 is null");
            return (Criteria) this;
        }

        public Criteria andCy7IsNotNull() {
            addCriterion("cy7 is not null");
            return (Criteria) this;
        }

        public Criteria andCy7EqualTo(String value) {
            addCriterion("cy7 =", value, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7NotEqualTo(String value) {
            addCriterion("cy7 <>", value, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7GreaterThan(String value) {
            addCriterion("cy7 >", value, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7GreaterThanOrEqualTo(String value) {
            addCriterion("cy7 >=", value, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7LessThan(String value) {
            addCriterion("cy7 <", value, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7LessThanOrEqualTo(String value) {
            addCriterion("cy7 <=", value, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7Like(String value) {
            addCriterion("cy7 like", value, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7NotLike(String value) {
            addCriterion("cy7 not like", value, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7In(List<String> values) {
            addCriterion("cy7 in", values, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7NotIn(List<String> values) {
            addCriterion("cy7 not in", values, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7Between(String value1, String value2) {
            addCriterion("cy7 between", value1, value2, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy7NotBetween(String value1, String value2) {
            addCriterion("cy7 not between", value1, value2, "cy7");
            return (Criteria) this;
        }

        public Criteria andCy8IsNull() {
            addCriterion("cy8 is null");
            return (Criteria) this;
        }

        public Criteria andCy8IsNotNull() {
            addCriterion("cy8 is not null");
            return (Criteria) this;
        }

        public Criteria andCy8EqualTo(String value) {
            addCriterion("cy8 =", value, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8NotEqualTo(String value) {
            addCriterion("cy8 <>", value, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8GreaterThan(String value) {
            addCriterion("cy8 >", value, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8GreaterThanOrEqualTo(String value) {
            addCriterion("cy8 >=", value, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8LessThan(String value) {
            addCriterion("cy8 <", value, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8LessThanOrEqualTo(String value) {
            addCriterion("cy8 <=", value, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8Like(String value) {
            addCriterion("cy8 like", value, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8NotLike(String value) {
            addCriterion("cy8 not like", value, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8In(List<String> values) {
            addCriterion("cy8 in", values, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8NotIn(List<String> values) {
            addCriterion("cy8 not in", values, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8Between(String value1, String value2) {
            addCriterion("cy8 between", value1, value2, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy8NotBetween(String value1, String value2) {
            addCriterion("cy8 not between", value1, value2, "cy8");
            return (Criteria) this;
        }

        public Criteria andCy9IsNull() {
            addCriterion("cy9 is null");
            return (Criteria) this;
        }

        public Criteria andCy9IsNotNull() {
            addCriterion("cy9 is not null");
            return (Criteria) this;
        }

        public Criteria andCy9EqualTo(String value) {
            addCriterion("cy9 =", value, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9NotEqualTo(String value) {
            addCriterion("cy9 <>", value, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9GreaterThan(String value) {
            addCriterion("cy9 >", value, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9GreaterThanOrEqualTo(String value) {
            addCriterion("cy9 >=", value, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9LessThan(String value) {
            addCriterion("cy9 <", value, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9LessThanOrEqualTo(String value) {
            addCriterion("cy9 <=", value, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9Like(String value) {
            addCriterion("cy9 like", value, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9NotLike(String value) {
            addCriterion("cy9 not like", value, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9In(List<String> values) {
            addCriterion("cy9 in", values, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9NotIn(List<String> values) {
            addCriterion("cy9 not in", values, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9Between(String value1, String value2) {
            addCriterion("cy9 between", value1, value2, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy9NotBetween(String value1, String value2) {
            addCriterion("cy9 not between", value1, value2, "cy9");
            return (Criteria) this;
        }

        public Criteria andCy10IsNull() {
            addCriterion("cy10 is null");
            return (Criteria) this;
        }

        public Criteria andCy10IsNotNull() {
            addCriterion("cy10 is not null");
            return (Criteria) this;
        }

        public Criteria andCy10EqualTo(String value) {
            addCriterion("cy10 =", value, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10NotEqualTo(String value) {
            addCriterion("cy10 <>", value, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10GreaterThan(String value) {
            addCriterion("cy10 >", value, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10GreaterThanOrEqualTo(String value) {
            addCriterion("cy10 >=", value, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10LessThan(String value) {
            addCriterion("cy10 <", value, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10LessThanOrEqualTo(String value) {
            addCriterion("cy10 <=", value, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10Like(String value) {
            addCriterion("cy10 like", value, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10NotLike(String value) {
            addCriterion("cy10 not like", value, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10In(List<String> values) {
            addCriterion("cy10 in", values, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10NotIn(List<String> values) {
            addCriterion("cy10 not in", values, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10Between(String value1, String value2) {
            addCriterion("cy10 between", value1, value2, "cy10");
            return (Criteria) this;
        }

        public Criteria andCy10NotBetween(String value1, String value2) {
            addCriterion("cy10 not between", value1, value2, "cy10");
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
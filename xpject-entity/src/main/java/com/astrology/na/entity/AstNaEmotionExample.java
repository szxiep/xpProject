package com.astrology.na.entity;

import java.util.ArrayList;
import java.util.List;

public class AstNaEmotionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AstNaEmotionExample() {
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

        public Criteria andCy11IsNull() {
            addCriterion("cy11 is null");
            return (Criteria) this;
        }

        public Criteria andCy11IsNotNull() {
            addCriterion("cy11 is not null");
            return (Criteria) this;
        }

        public Criteria andCy11EqualTo(String value) {
            addCriterion("cy11 =", value, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11NotEqualTo(String value) {
            addCriterion("cy11 <>", value, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11GreaterThan(String value) {
            addCriterion("cy11 >", value, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11GreaterThanOrEqualTo(String value) {
            addCriterion("cy11 >=", value, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11LessThan(String value) {
            addCriterion("cy11 <", value, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11LessThanOrEqualTo(String value) {
            addCriterion("cy11 <=", value, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11Like(String value) {
            addCriterion("cy11 like", value, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11NotLike(String value) {
            addCriterion("cy11 not like", value, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11In(List<String> values) {
            addCriterion("cy11 in", values, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11NotIn(List<String> values) {
            addCriterion("cy11 not in", values, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11Between(String value1, String value2) {
            addCriterion("cy11 between", value1, value2, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy11NotBetween(String value1, String value2) {
            addCriterion("cy11 not between", value1, value2, "cy11");
            return (Criteria) this;
        }

        public Criteria andCy12IsNull() {
            addCriterion("cy12 is null");
            return (Criteria) this;
        }

        public Criteria andCy12IsNotNull() {
            addCriterion("cy12 is not null");
            return (Criteria) this;
        }

        public Criteria andCy12EqualTo(String value) {
            addCriterion("cy12 =", value, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12NotEqualTo(String value) {
            addCriterion("cy12 <>", value, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12GreaterThan(String value) {
            addCriterion("cy12 >", value, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12GreaterThanOrEqualTo(String value) {
            addCriterion("cy12 >=", value, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12LessThan(String value) {
            addCriterion("cy12 <", value, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12LessThanOrEqualTo(String value) {
            addCriterion("cy12 <=", value, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12Like(String value) {
            addCriterion("cy12 like", value, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12NotLike(String value) {
            addCriterion("cy12 not like", value, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12In(List<String> values) {
            addCriterion("cy12 in", values, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12NotIn(List<String> values) {
            addCriterion("cy12 not in", values, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12Between(String value1, String value2) {
            addCriterion("cy12 between", value1, value2, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy12NotBetween(String value1, String value2) {
            addCriterion("cy12 not between", value1, value2, "cy12");
            return (Criteria) this;
        }

        public Criteria andCy13IsNull() {
            addCriterion("cy13 is null");
            return (Criteria) this;
        }

        public Criteria andCy13IsNotNull() {
            addCriterion("cy13 is not null");
            return (Criteria) this;
        }

        public Criteria andCy13EqualTo(String value) {
            addCriterion("cy13 =", value, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13NotEqualTo(String value) {
            addCriterion("cy13 <>", value, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13GreaterThan(String value) {
            addCriterion("cy13 >", value, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13GreaterThanOrEqualTo(String value) {
            addCriterion("cy13 >=", value, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13LessThan(String value) {
            addCriterion("cy13 <", value, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13LessThanOrEqualTo(String value) {
            addCriterion("cy13 <=", value, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13Like(String value) {
            addCriterion("cy13 like", value, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13NotLike(String value) {
            addCriterion("cy13 not like", value, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13In(List<String> values) {
            addCriterion("cy13 in", values, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13NotIn(List<String> values) {
            addCriterion("cy13 not in", values, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13Between(String value1, String value2) {
            addCriterion("cy13 between", value1, value2, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy13NotBetween(String value1, String value2) {
            addCriterion("cy13 not between", value1, value2, "cy13");
            return (Criteria) this;
        }

        public Criteria andCy14IsNull() {
            addCriterion("cy14 is null");
            return (Criteria) this;
        }

        public Criteria andCy14IsNotNull() {
            addCriterion("cy14 is not null");
            return (Criteria) this;
        }

        public Criteria andCy14EqualTo(String value) {
            addCriterion("cy14 =", value, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14NotEqualTo(String value) {
            addCriterion("cy14 <>", value, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14GreaterThan(String value) {
            addCriterion("cy14 >", value, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14GreaterThanOrEqualTo(String value) {
            addCriterion("cy14 >=", value, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14LessThan(String value) {
            addCriterion("cy14 <", value, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14LessThanOrEqualTo(String value) {
            addCriterion("cy14 <=", value, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14Like(String value) {
            addCriterion("cy14 like", value, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14NotLike(String value) {
            addCriterion("cy14 not like", value, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14In(List<String> values) {
            addCriterion("cy14 in", values, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14NotIn(List<String> values) {
            addCriterion("cy14 not in", values, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14Between(String value1, String value2) {
            addCriterion("cy14 between", value1, value2, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy14NotBetween(String value1, String value2) {
            addCriterion("cy14 not between", value1, value2, "cy14");
            return (Criteria) this;
        }

        public Criteria andCy15IsNull() {
            addCriterion("cy15 is null");
            return (Criteria) this;
        }

        public Criteria andCy15IsNotNull() {
            addCriterion("cy15 is not null");
            return (Criteria) this;
        }

        public Criteria andCy15EqualTo(String value) {
            addCriterion("cy15 =", value, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15NotEqualTo(String value) {
            addCriterion("cy15 <>", value, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15GreaterThan(String value) {
            addCriterion("cy15 >", value, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15GreaterThanOrEqualTo(String value) {
            addCriterion("cy15 >=", value, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15LessThan(String value) {
            addCriterion("cy15 <", value, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15LessThanOrEqualTo(String value) {
            addCriterion("cy15 <=", value, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15Like(String value) {
            addCriterion("cy15 like", value, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15NotLike(String value) {
            addCriterion("cy15 not like", value, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15In(List<String> values) {
            addCriterion("cy15 in", values, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15NotIn(List<String> values) {
            addCriterion("cy15 not in", values, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15Between(String value1, String value2) {
            addCriterion("cy15 between", value1, value2, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy15NotBetween(String value1, String value2) {
            addCriterion("cy15 not between", value1, value2, "cy15");
            return (Criteria) this;
        }

        public Criteria andCy16IsNull() {
            addCriterion("cy16 is null");
            return (Criteria) this;
        }

        public Criteria andCy16IsNotNull() {
            addCriterion("cy16 is not null");
            return (Criteria) this;
        }

        public Criteria andCy16EqualTo(String value) {
            addCriterion("cy16 =", value, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16NotEqualTo(String value) {
            addCriterion("cy16 <>", value, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16GreaterThan(String value) {
            addCriterion("cy16 >", value, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16GreaterThanOrEqualTo(String value) {
            addCriterion("cy16 >=", value, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16LessThan(String value) {
            addCriterion("cy16 <", value, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16LessThanOrEqualTo(String value) {
            addCriterion("cy16 <=", value, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16Like(String value) {
            addCriterion("cy16 like", value, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16NotLike(String value) {
            addCriterion("cy16 not like", value, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16In(List<String> values) {
            addCriterion("cy16 in", values, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16NotIn(List<String> values) {
            addCriterion("cy16 not in", values, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16Between(String value1, String value2) {
            addCriterion("cy16 between", value1, value2, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy16NotBetween(String value1, String value2) {
            addCriterion("cy16 not between", value1, value2, "cy16");
            return (Criteria) this;
        }

        public Criteria andCy17IsNull() {
            addCriterion("cy17 is null");
            return (Criteria) this;
        }

        public Criteria andCy17IsNotNull() {
            addCriterion("cy17 is not null");
            return (Criteria) this;
        }

        public Criteria andCy17EqualTo(String value) {
            addCriterion("cy17 =", value, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17NotEqualTo(String value) {
            addCriterion("cy17 <>", value, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17GreaterThan(String value) {
            addCriterion("cy17 >", value, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17GreaterThanOrEqualTo(String value) {
            addCriterion("cy17 >=", value, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17LessThan(String value) {
            addCriterion("cy17 <", value, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17LessThanOrEqualTo(String value) {
            addCriterion("cy17 <=", value, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17Like(String value) {
            addCriterion("cy17 like", value, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17NotLike(String value) {
            addCriterion("cy17 not like", value, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17In(List<String> values) {
            addCriterion("cy17 in", values, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17NotIn(List<String> values) {
            addCriterion("cy17 not in", values, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17Between(String value1, String value2) {
            addCriterion("cy17 between", value1, value2, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy17NotBetween(String value1, String value2) {
            addCriterion("cy17 not between", value1, value2, "cy17");
            return (Criteria) this;
        }

        public Criteria andCy18IsNull() {
            addCriterion("cy18 is null");
            return (Criteria) this;
        }

        public Criteria andCy18IsNotNull() {
            addCriterion("cy18 is not null");
            return (Criteria) this;
        }

        public Criteria andCy18EqualTo(String value) {
            addCriterion("cy18 =", value, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18NotEqualTo(String value) {
            addCriterion("cy18 <>", value, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18GreaterThan(String value) {
            addCriterion("cy18 >", value, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18GreaterThanOrEqualTo(String value) {
            addCriterion("cy18 >=", value, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18LessThan(String value) {
            addCriterion("cy18 <", value, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18LessThanOrEqualTo(String value) {
            addCriterion("cy18 <=", value, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18Like(String value) {
            addCriterion("cy18 like", value, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18NotLike(String value) {
            addCriterion("cy18 not like", value, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18In(List<String> values) {
            addCriterion("cy18 in", values, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18NotIn(List<String> values) {
            addCriterion("cy18 not in", values, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18Between(String value1, String value2) {
            addCriterion("cy18 between", value1, value2, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy18NotBetween(String value1, String value2) {
            addCriterion("cy18 not between", value1, value2, "cy18");
            return (Criteria) this;
        }

        public Criteria andCy19IsNull() {
            addCriterion("cy19 is null");
            return (Criteria) this;
        }

        public Criteria andCy19IsNotNull() {
            addCriterion("cy19 is not null");
            return (Criteria) this;
        }

        public Criteria andCy19EqualTo(String value) {
            addCriterion("cy19 =", value, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19NotEqualTo(String value) {
            addCriterion("cy19 <>", value, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19GreaterThan(String value) {
            addCriterion("cy19 >", value, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19GreaterThanOrEqualTo(String value) {
            addCriterion("cy19 >=", value, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19LessThan(String value) {
            addCriterion("cy19 <", value, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19LessThanOrEqualTo(String value) {
            addCriterion("cy19 <=", value, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19Like(String value) {
            addCriterion("cy19 like", value, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19NotLike(String value) {
            addCriterion("cy19 not like", value, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19In(List<String> values) {
            addCriterion("cy19 in", values, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19NotIn(List<String> values) {
            addCriterion("cy19 not in", values, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19Between(String value1, String value2) {
            addCriterion("cy19 between", value1, value2, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy19NotBetween(String value1, String value2) {
            addCriterion("cy19 not between", value1, value2, "cy19");
            return (Criteria) this;
        }

        public Criteria andCy20IsNull() {
            addCriterion("cy20 is null");
            return (Criteria) this;
        }

        public Criteria andCy20IsNotNull() {
            addCriterion("cy20 is not null");
            return (Criteria) this;
        }

        public Criteria andCy20EqualTo(String value) {
            addCriterion("cy20 =", value, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20NotEqualTo(String value) {
            addCriterion("cy20 <>", value, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20GreaterThan(String value) {
            addCriterion("cy20 >", value, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20GreaterThanOrEqualTo(String value) {
            addCriterion("cy20 >=", value, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20LessThan(String value) {
            addCriterion("cy20 <", value, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20LessThanOrEqualTo(String value) {
            addCriterion("cy20 <=", value, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20Like(String value) {
            addCriterion("cy20 like", value, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20NotLike(String value) {
            addCriterion("cy20 not like", value, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20In(List<String> values) {
            addCriterion("cy20 in", values, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20NotIn(List<String> values) {
            addCriterion("cy20 not in", values, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20Between(String value1, String value2) {
            addCriterion("cy20 between", value1, value2, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy20NotBetween(String value1, String value2) {
            addCriterion("cy20 not between", value1, value2, "cy20");
            return (Criteria) this;
        }

        public Criteria andCy21IsNull() {
            addCriterion("cy21 is null");
            return (Criteria) this;
        }

        public Criteria andCy21IsNotNull() {
            addCriterion("cy21 is not null");
            return (Criteria) this;
        }

        public Criteria andCy21EqualTo(String value) {
            addCriterion("cy21 =", value, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21NotEqualTo(String value) {
            addCriterion("cy21 <>", value, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21GreaterThan(String value) {
            addCriterion("cy21 >", value, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21GreaterThanOrEqualTo(String value) {
            addCriterion("cy21 >=", value, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21LessThan(String value) {
            addCriterion("cy21 <", value, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21LessThanOrEqualTo(String value) {
            addCriterion("cy21 <=", value, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21Like(String value) {
            addCriterion("cy21 like", value, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21NotLike(String value) {
            addCriterion("cy21 not like", value, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21In(List<String> values) {
            addCriterion("cy21 in", values, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21NotIn(List<String> values) {
            addCriterion("cy21 not in", values, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21Between(String value1, String value2) {
            addCriterion("cy21 between", value1, value2, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy21NotBetween(String value1, String value2) {
            addCriterion("cy21 not between", value1, value2, "cy21");
            return (Criteria) this;
        }

        public Criteria andCy22IsNull() {
            addCriterion("cy22 is null");
            return (Criteria) this;
        }

        public Criteria andCy22IsNotNull() {
            addCriterion("cy22 is not null");
            return (Criteria) this;
        }

        public Criteria andCy22EqualTo(String value) {
            addCriterion("cy22 =", value, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22NotEqualTo(String value) {
            addCriterion("cy22 <>", value, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22GreaterThan(String value) {
            addCriterion("cy22 >", value, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22GreaterThanOrEqualTo(String value) {
            addCriterion("cy22 >=", value, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22LessThan(String value) {
            addCriterion("cy22 <", value, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22LessThanOrEqualTo(String value) {
            addCriterion("cy22 <=", value, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22Like(String value) {
            addCriterion("cy22 like", value, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22NotLike(String value) {
            addCriterion("cy22 not like", value, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22In(List<String> values) {
            addCriterion("cy22 in", values, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22NotIn(List<String> values) {
            addCriterion("cy22 not in", values, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22Between(String value1, String value2) {
            addCriterion("cy22 between", value1, value2, "cy22");
            return (Criteria) this;
        }

        public Criteria andCy22NotBetween(String value1, String value2) {
            addCriterion("cy22 not between", value1, value2, "cy22");
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
package org.smcoder.cvoid.example;

import java.util.ArrayList;
import java.util.List;

public class SmCountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public SmCountExample() {
        oredCriteria = new ArrayList<>();
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

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andAddressIdIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(String value) {
            addCriterion("address_id =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(String value) {
            addCriterion("address_id <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(String value) {
            addCriterion("address_id >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(String value) {
            addCriterion("address_id >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(String value) {
            addCriterion("address_id <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(String value) {
            addCriterion("address_id <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<String> values) {
            addCriterion("address_id in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<Integer> values) {
            addCriterion("address_id not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(String value1, String value2) {
            addCriterion("address_id between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(String value1, String value2) {
            addCriterion("address_id not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andNewAddIsNull() {
            addCriterion("new_add is null");
            return (Criteria) this;
        }

        public Criteria andNewAddIsNotNull() {
            addCriterion("new_add is not null");
            return (Criteria) this;
        }

        public Criteria andNewAddEqualTo(Integer value) {
            addCriterion("new_add =", value, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddNotEqualTo(Integer value) {
            addCriterion("new_add <>", value, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddGreaterThan(Integer value) {
            addCriterion("new_add >", value, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_add >=", value, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddLessThan(Integer value) {
            addCriterion("new_add <", value, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddLessThanOrEqualTo(Integer value) {
            addCriterion("new_add <=", value, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddIn(List<Integer> values) {
            addCriterion("new_add in", values, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddNotIn(List<Integer> values) {
            addCriterion("new_add not in", values, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddBetween(Integer value1, Integer value2) {
            addCriterion("new_add between", value1, value2, "newAdd");
            return (Criteria) this;
        }

        public Criteria andNewAddNotBetween(Integer value1, Integer value2) {
            addCriterion("new_add not between", value1, value2, "newAdd");
            return (Criteria) this;
        }

        public Criteria andSumCountIsNull() {
            addCriterion("sum_count is null");
            return (Criteria) this;
        }

        public Criteria andSumCountIsNotNull() {
            addCriterion("sum_count is not null");
            return (Criteria) this;
        }

        public Criteria andSumCountEqualTo(Integer value) {
            addCriterion("sum_count =", value, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountNotEqualTo(Integer value) {
            addCriterion("sum_count <>", value, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountGreaterThan(Integer value) {
            addCriterion("sum_count >", value, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_count >=", value, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountLessThan(Integer value) {
            addCriterion("sum_count <", value, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountLessThanOrEqualTo(Integer value) {
            addCriterion("sum_count <=", value, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountIn(List<Integer> values) {
            addCriterion("sum_count in", values, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountNotIn(List<Integer> values) {
            addCriterion("sum_count not in", values, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountBetween(Integer value1, Integer value2) {
            addCriterion("sum_count between", value1, value2, "sumCount");
            return (Criteria) this;
        }

        public Criteria andSumCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_count not between", value1, value2, "sumCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountIsNull() {
            addCriterion("good_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodCountIsNotNull() {
            addCriterion("good_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodCountEqualTo(Integer value) {
            addCriterion("good_count =", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotEqualTo(Integer value) {
            addCriterion("good_count <>", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountGreaterThan(Integer value) {
            addCriterion("good_count >", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_count >=", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountLessThan(Integer value) {
            addCriterion("good_count <", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountLessThanOrEqualTo(Integer value) {
            addCriterion("good_count <=", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountIn(List<Integer> values) {
            addCriterion("good_count in", values, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotIn(List<Integer> values) {
            addCriterion("good_count not in", values, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountBetween(Integer value1, Integer value2) {
            addCriterion("good_count between", value1, value2, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotBetween(Integer value1, Integer value2) {
            addCriterion("good_count not between", value1, value2, "goodCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountIsNull() {
            addCriterion("death_count is null");
            return (Criteria) this;
        }

        public Criteria andDeathCountIsNotNull() {
            addCriterion("death_count is not null");
            return (Criteria) this;
        }

        public Criteria andDeathCountEqualTo(Integer value) {
            addCriterion("death_count =", value, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountNotEqualTo(Integer value) {
            addCriterion("death_count <>", value, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountGreaterThan(Integer value) {
            addCriterion("death_count >", value, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("death_count >=", value, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountLessThan(Integer value) {
            addCriterion("death_count <", value, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountLessThanOrEqualTo(Integer value) {
            addCriterion("death_count <=", value, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountIn(List<Integer> values) {
            addCriterion("death_count in", values, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountNotIn(List<Integer> values) {
            addCriterion("death_count not in", values, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountBetween(Integer value1, Integer value2) {
            addCriterion("death_count between", value1, value2, "deathCount");
            return (Criteria) this;
        }

        public Criteria andDeathCountNotBetween(Integer value1, Integer value2) {
            addCriterion("death_count not between", value1, value2, "deathCount");
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
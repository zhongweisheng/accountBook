package lb.rest.user.db.entity;

import java.util.ArrayList;
import java.util.List;

public class BsSequenceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    protected List<Criteria> oredCriteria;

    private int limit;

    private int offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public BsSequenceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
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

        public Criteria andDepotIdIsNull() {
            addCriterion("depot_id is null");
            return (Criteria) this;
        }

        public Criteria andDepotIdIsNotNull() {
            addCriterion("depot_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepotIdEqualTo(Integer value) {
            addCriterion("depot_id =", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotEqualTo(Integer value) {
            addCriterion("depot_id <>", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdGreaterThan(Integer value) {
            addCriterion("depot_id >", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("depot_id >=", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdLessThan(Integer value) {
            addCriterion("depot_id <", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdLessThanOrEqualTo(Integer value) {
            addCriterion("depot_id <=", value, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdIn(List<Integer> values) {
            addCriterion("depot_id in", values, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotIn(List<Integer> values) {
            addCriterion("depot_id not in", values, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdBetween(Integer value1, Integer value2) {
            addCriterion("depot_id between", value1, value2, "depotId");
            return (Criteria) this;
        }

        public Criteria andDepotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("depot_id not between", value1, value2, "depotId");
            return (Criteria) this;
        }

        public Criteria andKeyIdIsNull() {
            addCriterion("key_id is null");
            return (Criteria) this;
        }

        public Criteria andKeyIdIsNotNull() {
            addCriterion("key_id is not null");
            return (Criteria) this;
        }

        public Criteria andKeyIdEqualTo(Integer value) {
            addCriterion("key_id =", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotEqualTo(Integer value) {
            addCriterion("key_id <>", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdGreaterThan(Integer value) {
            addCriterion("key_id >", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("key_id >=", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLessThan(Integer value) {
            addCriterion("key_id <", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLessThanOrEqualTo(Integer value) {
            addCriterion("key_id <=", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdIn(List<Integer> values) {
            addCriterion("key_id in", values, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotIn(List<Integer> values) {
            addCriterion("key_id not in", values, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdBetween(Integer value1, Integer value2) {
            addCriterion("key_id between", value1, value2, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("key_id not between", value1, value2, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryIsNull() {
            addCriterion("key_category is null");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryIsNotNull() {
            addCriterion("key_category is not null");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryEqualTo(Integer value) {
            addCriterion("key_category =", value, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryNotEqualTo(Integer value) {
            addCriterion("key_category <>", value, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryGreaterThan(Integer value) {
            addCriterion("key_category >", value, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("key_category >=", value, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryLessThan(Integer value) {
            addCriterion("key_category <", value, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("key_category <=", value, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryIn(List<Integer> values) {
            addCriterion("key_category in", values, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryNotIn(List<Integer> values) {
            addCriterion("key_category not in", values, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryBetween(Integer value1, Integer value2) {
            addCriterion("key_category between", value1, value2, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("key_category not between", value1, value2, "keyCategory");
            return (Criteria) this;
        }

        public Criteria andKeyTypeIsNull() {
            addCriterion("key_type is null");
            return (Criteria) this;
        }

        public Criteria andKeyTypeIsNotNull() {
            addCriterion("key_type is not null");
            return (Criteria) this;
        }

        public Criteria andKeyTypeEqualTo(Integer value) {
            addCriterion("key_type =", value, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeNotEqualTo(Integer value) {
            addCriterion("key_type <>", value, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeGreaterThan(Integer value) {
            addCriterion("key_type >", value, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("key_type >=", value, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeLessThan(Integer value) {
            addCriterion("key_type <", value, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("key_type <=", value, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeIn(List<Integer> values) {
            addCriterion("key_type in", values, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeNotIn(List<Integer> values) {
            addCriterion("key_type not in", values, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeBetween(Integer value1, Integer value2) {
            addCriterion("key_type between", value1, value2, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("key_type not between", value1, value2, "keyType");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNull() {
            addCriterion("key_value is null");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNotNull() {
            addCriterion("key_value is not null");
            return (Criteria) this;
        }

        public Criteria andKeyValueEqualTo(Integer value) {
            addCriterion("key_value =", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotEqualTo(Integer value) {
            addCriterion("key_value <>", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThan(Integer value) {
            addCriterion("key_value >", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("key_value >=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThan(Integer value) {
            addCriterion("key_value <", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThanOrEqualTo(Integer value) {
            addCriterion("key_value <=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueIn(List<Integer> values) {
            addCriterion("key_value in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotIn(List<Integer> values) {
            addCriterion("key_value not in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueBetween(Integer value1, Integer value2) {
            addCriterion("key_value between", value1, value2, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotBetween(Integer value1, Integer value2) {
            addCriterion("key_value not between", value1, value2, "keyValue");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bs_sequence
     *
     * @mbggenerated do_not_delete_during_merge Mon May 15 11:47:33 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
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
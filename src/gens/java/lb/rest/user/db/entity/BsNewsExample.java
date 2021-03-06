package lb.rest.user.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BsNewsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    protected List<Criteria> oredCriteria;

    private int limit;

    private int offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public BsNewsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
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
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
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
     * This class corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNull() {
            addCriterion("createUserId is null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIsNotNull() {
            addCriterion("createUserId is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuseridEqualTo(Integer value) {
            addCriterion("createUserId =", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotEqualTo(Integer value) {
            addCriterion("createUserId <>", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThan(Integer value) {
            addCriterion("createUserId >", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("createUserId >=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThan(Integer value) {
            addCriterion("createUserId <", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridLessThanOrEqualTo(Integer value) {
            addCriterion("createUserId <=", value, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridIn(List<Integer> values) {
            addCriterion("createUserId in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotIn(List<Integer> values) {
            addCriterion("createUserId not in", values, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridBetween(Integer value1, Integer value2) {
            addCriterion("createUserId between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("createUserId not between", value1, value2, "createuserid");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIsNull() {
            addCriterion("createUserName is null");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIsNotNull() {
            addCriterion("createUserName is not null");
            return (Criteria) this;
        }

        public Criteria andCreateusernameEqualTo(String value) {
            addCriterion("createUserName =", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotEqualTo(String value) {
            addCriterion("createUserName <>", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameGreaterThan(String value) {
            addCriterion("createUserName >", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameGreaterThanOrEqualTo(String value) {
            addCriterion("createUserName >=", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLessThan(String value) {
            addCriterion("createUserName <", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLessThanOrEqualTo(String value) {
            addCriterion("createUserName <=", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameLike(String value) {
            addCriterion("createUserName like", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotLike(String value) {
            addCriterion("createUserName not like", value, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameIn(List<String> values) {
            addCriterion("createUserName in", values, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotIn(List<String> values) {
            addCriterion("createUserName not in", values, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameBetween(String value1, String value2) {
            addCriterion("createUserName between", value1, value2, "createusername");
            return (Criteria) this;
        }

        public Criteria andCreateusernameNotBetween(String value1, String value2) {
            addCriterion("createUserName not between", value1, value2, "createusername");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIsNull() {
            addCriterion("updateUserId is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIsNotNull() {
            addCriterion("updateUserId is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridEqualTo(Integer value) {
            addCriterion("updateUserId =", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotEqualTo(Integer value) {
            addCriterion("updateUserId <>", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridGreaterThan(Integer value) {
            addCriterion("updateUserId >", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("updateUserId >=", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridLessThan(Integer value) {
            addCriterion("updateUserId <", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridLessThanOrEqualTo(Integer value) {
            addCriterion("updateUserId <=", value, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridIn(List<Integer> values) {
            addCriterion("updateUserId in", values, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotIn(List<Integer> values) {
            addCriterion("updateUserId not in", values, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridBetween(Integer value1, Integer value2) {
            addCriterion("updateUserId between", value1, value2, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("updateUserId not between", value1, value2, "updateuserid");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIsNull() {
            addCriterion("updateUserName is null");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIsNotNull() {
            addCriterion("updateUserName is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameEqualTo(String value) {
            addCriterion("updateUserName =", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotEqualTo(String value) {
            addCriterion("updateUserName <>", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameGreaterThan(String value) {
            addCriterion("updateUserName >", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameGreaterThanOrEqualTo(String value) {
            addCriterion("updateUserName >=", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLessThan(String value) {
            addCriterion("updateUserName <", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLessThanOrEqualTo(String value) {
            addCriterion("updateUserName <=", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLike(String value) {
            addCriterion("updateUserName like", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotLike(String value) {
            addCriterion("updateUserName not like", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIn(List<String> values) {
            addCriterion("updateUserName in", values, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotIn(List<String> values) {
            addCriterion("updateUserName not in", values, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameBetween(String value1, String value2) {
            addCriterion("updateUserName between", value1, value2, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotBetween(String value1, String value2) {
            addCriterion("updateUserName not between", value1, value2, "updateusername");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1IsNull() {
            addCriterion("intColumn1 is null");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1IsNotNull() {
            addCriterion("intColumn1 is not null");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1EqualTo(Integer value) {
            addCriterion("intColumn1 =", value, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1NotEqualTo(Integer value) {
            addCriterion("intColumn1 <>", value, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1GreaterThan(Integer value) {
            addCriterion("intColumn1 >", value, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1GreaterThanOrEqualTo(Integer value) {
            addCriterion("intColumn1 >=", value, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1LessThan(Integer value) {
            addCriterion("intColumn1 <", value, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1LessThanOrEqualTo(Integer value) {
            addCriterion("intColumn1 <=", value, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1In(List<Integer> values) {
            addCriterion("intColumn1 in", values, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1NotIn(List<Integer> values) {
            addCriterion("intColumn1 not in", values, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1Between(Integer value1, Integer value2) {
            addCriterion("intColumn1 between", value1, value2, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn1NotBetween(Integer value1, Integer value2) {
            addCriterion("intColumn1 not between", value1, value2, "intcolumn1");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2IsNull() {
            addCriterion("intColumn2 is null");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2IsNotNull() {
            addCriterion("intColumn2 is not null");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2EqualTo(Integer value) {
            addCriterion("intColumn2 =", value, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2NotEqualTo(Integer value) {
            addCriterion("intColumn2 <>", value, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2GreaterThan(Integer value) {
            addCriterion("intColumn2 >", value, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2GreaterThanOrEqualTo(Integer value) {
            addCriterion("intColumn2 >=", value, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2LessThan(Integer value) {
            addCriterion("intColumn2 <", value, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2LessThanOrEqualTo(Integer value) {
            addCriterion("intColumn2 <=", value, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2In(List<Integer> values) {
            addCriterion("intColumn2 in", values, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2NotIn(List<Integer> values) {
            addCriterion("intColumn2 not in", values, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2Between(Integer value1, Integer value2) {
            addCriterion("intColumn2 between", value1, value2, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andIntcolumn2NotBetween(Integer value1, Integer value2) {
            addCriterion("intColumn2 not between", value1, value2, "intcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1IsNull() {
            addCriterion("strColumn1 is null");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1IsNotNull() {
            addCriterion("strColumn1 is not null");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1EqualTo(String value) {
            addCriterion("strColumn1 =", value, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1NotEqualTo(String value) {
            addCriterion("strColumn1 <>", value, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1GreaterThan(String value) {
            addCriterion("strColumn1 >", value, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1GreaterThanOrEqualTo(String value) {
            addCriterion("strColumn1 >=", value, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1LessThan(String value) {
            addCriterion("strColumn1 <", value, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1LessThanOrEqualTo(String value) {
            addCriterion("strColumn1 <=", value, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1Like(String value) {
            addCriterion("strColumn1 like", value, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1NotLike(String value) {
            addCriterion("strColumn1 not like", value, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1In(List<String> values) {
            addCriterion("strColumn1 in", values, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1NotIn(List<String> values) {
            addCriterion("strColumn1 not in", values, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1Between(String value1, String value2) {
            addCriterion("strColumn1 between", value1, value2, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn1NotBetween(String value1, String value2) {
            addCriterion("strColumn1 not between", value1, value2, "strcolumn1");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2IsNull() {
            addCriterion("strColumn2 is null");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2IsNotNull() {
            addCriterion("strColumn2 is not null");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2EqualTo(String value) {
            addCriterion("strColumn2 =", value, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2NotEqualTo(String value) {
            addCriterion("strColumn2 <>", value, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2GreaterThan(String value) {
            addCriterion("strColumn2 >", value, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2GreaterThanOrEqualTo(String value) {
            addCriterion("strColumn2 >=", value, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2LessThan(String value) {
            addCriterion("strColumn2 <", value, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2LessThanOrEqualTo(String value) {
            addCriterion("strColumn2 <=", value, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2Like(String value) {
            addCriterion("strColumn2 like", value, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2NotLike(String value) {
            addCriterion("strColumn2 not like", value, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2In(List<String> values) {
            addCriterion("strColumn2 in", values, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2NotIn(List<String> values) {
            addCriterion("strColumn2 not in", values, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2Between(String value1, String value2) {
            addCriterion("strColumn2 between", value1, value2, "strcolumn2");
            return (Criteria) this;
        }

        public Criteria andStrcolumn2NotBetween(String value1, String value2) {
            addCriterion("strColumn2 not between", value1, value2, "strcolumn2");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bs_news
     *
     * @mbggenerated do_not_delete_during_merge Fri Mar 31 14:55:39 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
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
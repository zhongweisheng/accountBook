package lb.rest.user.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlbSuggestionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    protected List<Criteria> oredCriteria;

    protected int offset;

    protected int limit;

    protected String sumCol;

    protected String groupSelClause;

    protected String groupByClause;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public MlbSuggestionExample() {
        oredCriteria = new ArrayList<Criteria>();
        offset = 0;
        limit = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
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
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        this.offset= 0;
        this.limit= Integer.MAX_VALUE;
        this.sumCol=null;
        this.groupSelClause=null;
        this.groupByClause=null;
    }

    public void setOffset(int offset) {
         this.offset = offset;
    }

    public int getOffset() {
          return offset;
    }

    public void setLimit(int limit) {
         this.limit = limit;
    }

    public int getLimit() {
          return limit;
    }

    public void setSumCol(String sumCol) {
         this.sumCol = sumCol;
    }

    public String getSumCol() {
          return sumCol;
    }

    public void setGroupSelClause(String groupSelClause) {
         this.groupSelClause = groupSelClause;
    }

    public String getGroupSelClause() {
          return groupSelClause;
    }

    public void setGroupByClause(String groupByClause) {
         this.groupByClause = groupByClause;
    }

    public String getGroupByClause() {
          return groupByClause;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
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

        public Criteria andMlbuseridIsNull() {
            addCriterion("mlbUserId is null");
            return (Criteria) this;
        }

        public Criteria andMlbuseridIsNotNull() {
            addCriterion("mlbUserId is not null");
            return (Criteria) this;
        }

        public Criteria andMlbuseridEqualTo(Integer value) {
            addCriterion("mlbUserId =", value, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridNotEqualTo(Integer value) {
            addCriterion("mlbUserId <>", value, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridGreaterThan(Integer value) {
            addCriterion("mlbUserId >", value, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("mlbUserId >=", value, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridLessThan(Integer value) {
            addCriterion("mlbUserId <", value, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridLessThanOrEqualTo(Integer value) {
            addCriterion("mlbUserId <=", value, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridIn(List<Integer> values) {
            addCriterion("mlbUserId in", values, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridNotIn(List<Integer> values) {
            addCriterion("mlbUserId not in", values, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridBetween(Integer value1, Integer value2) {
            addCriterion("mlbUserId between", value1, value2, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("mlbUserId not between", value1, value2, "mlbuserid");
            return (Criteria) this;
        }

        public Criteria andMlbusernameIsNull() {
            addCriterion("mlbUserName is null");
            return (Criteria) this;
        }

        public Criteria andMlbusernameIsNotNull() {
            addCriterion("mlbUserName is not null");
            return (Criteria) this;
        }

        public Criteria andMlbusernameEqualTo(String value) {
            addCriterion("mlbUserName =", value, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameNotEqualTo(String value) {
            addCriterion("mlbUserName <>", value, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameGreaterThan(String value) {
            addCriterion("mlbUserName >", value, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameGreaterThanOrEqualTo(String value) {
            addCriterion("mlbUserName >=", value, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameLessThan(String value) {
            addCriterion("mlbUserName <", value, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameLessThanOrEqualTo(String value) {
            addCriterion("mlbUserName <=", value, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameLike(String value) {
            addCriterion("mlbUserName like", value, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameNotLike(String value) {
            addCriterion("mlbUserName not like", value, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameIn(List<String> values) {
            addCriterion("mlbUserName in", values, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameNotIn(List<String> values) {
            addCriterion("mlbUserName not in", values, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameBetween(String value1, String value2) {
            addCriterion("mlbUserName between", value1, value2, "mlbusername");
            return (Criteria) this;
        }

        public Criteria andMlbusernameNotBetween(String value1, String value2) {
            addCriterion("mlbUserName not between", value1, value2, "mlbusername");
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

        public Criteria andSuggestionTimeIsNull() {
            addCriterion("suggestion_time is null");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeIsNotNull() {
            addCriterion("suggestion_time is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeEqualTo(Date value) {
            addCriterion("suggestion_time =", value, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeNotEqualTo(Date value) {
            addCriterion("suggestion_time <>", value, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeGreaterThan(Date value) {
            addCriterion("suggestion_time >", value, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("suggestion_time >=", value, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeLessThan(Date value) {
            addCriterion("suggestion_time <", value, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeLessThanOrEqualTo(Date value) {
            addCriterion("suggestion_time <=", value, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeIn(List<Date> values) {
            addCriterion("suggestion_time in", values, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeNotIn(List<Date> values) {
            addCriterion("suggestion_time not in", values, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeBetween(Date value1, Date value2) {
            addCriterion("suggestion_time between", value1, value2, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andSuggestionTimeNotBetween(Date value1, Date value2) {
            addCriterion("suggestion_time not between", value1, value2, "suggestionTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Date value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Date value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Date value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Date value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Date> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Date> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Date value1, Date value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNull() {
            addCriterion("deal_user is null");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNotNull() {
            addCriterion("deal_user is not null");
            return (Criteria) this;
        }

        public Criteria andDealUserEqualTo(Integer value) {
            addCriterion("deal_user =", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotEqualTo(Integer value) {
            addCriterion("deal_user <>", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThan(Integer value) {
            addCriterion("deal_user >", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_user >=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThan(Integer value) {
            addCriterion("deal_user <", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThanOrEqualTo(Integer value) {
            addCriterion("deal_user <=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserIn(List<Integer> values) {
            addCriterion("deal_user in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotIn(List<Integer> values) {
            addCriterion("deal_user not in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserBetween(Integer value1, Integer value2) {
            addCriterion("deal_user between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_user not between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andReplyMsgIsNull() {
            addCriterion("reply_msg is null");
            return (Criteria) this;
        }

        public Criteria andReplyMsgIsNotNull() {
            addCriterion("reply_msg is not null");
            return (Criteria) this;
        }

        public Criteria andReplyMsgEqualTo(String value) {
            addCriterion("reply_msg =", value, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgNotEqualTo(String value) {
            addCriterion("reply_msg <>", value, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgGreaterThan(String value) {
            addCriterion("reply_msg >", value, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgGreaterThanOrEqualTo(String value) {
            addCriterion("reply_msg >=", value, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgLessThan(String value) {
            addCriterion("reply_msg <", value, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgLessThanOrEqualTo(String value) {
            addCriterion("reply_msg <=", value, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgLike(String value) {
            addCriterion("reply_msg like", value, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgNotLike(String value) {
            addCriterion("reply_msg not like", value, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgIn(List<String> values) {
            addCriterion("reply_msg in", values, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgNotIn(List<String> values) {
            addCriterion("reply_msg not in", values, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgBetween(String value1, String value2) {
            addCriterion("reply_msg between", value1, value2, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andReplyMsgNotBetween(String value1, String value2) {
            addCriterion("reply_msg not between", value1, value2, "replyMsg");
            return (Criteria) this;
        }

        public Criteria andMlbusernameLikeInsensitive(String value) {
            addCriterion("upper(mlbUserName) like", value.toUpperCase(), "mlbusername");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andReplyMsgLikeInsensitive(String value) {
            addCriterion("upper(reply_msg) like", value.toUpperCase(), "replyMsg");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mlb_suggestion
     *
     * @mbggenerated do_not_delete_during_merge Thu Feb 16 17:53:29 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
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
package lb.rest.user.db.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlbVerificationCodeExample {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table mlb_verification_code
	 * 
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	protected String orderByClause;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	protected boolean distinct;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	protected int offset;

	protected int limit;

	protected String sumCol;

	protected String groupSelClause;

	protected String groupByClause;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public MlbVerificationCodeExample() {
		oredCriteria = new ArrayList<Criteria>();
		offset = 0;
		limit = Integer.MAX_VALUE;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
		this.offset = 0;
		this.limit = Integer.MAX_VALUE;
		this.sumCol = null;
		this.groupSelClause = null;
		this.groupByClause = null;
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
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
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

		public Criteria andPhoneIsNull() {
			addCriterion("phone is null");
			return (Criteria) this;
		}

		public Criteria andPhoneIsNotNull() {
			addCriterion("phone is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneEqualTo(String value) {
			addCriterion("phone =", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotEqualTo(String value) {
			addCriterion("phone <>", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThan(String value) {
			addCriterion("phone >", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("phone >=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThan(String value) {
			addCriterion("phone <", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLessThanOrEqualTo(String value) {
			addCriterion("phone <=", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneLike(String value) {
			addCriterion("phone like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotLike(String value) {
			addCriterion("phone not like", value, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneIn(List<String> values) {
			addCriterion("phone in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotIn(List<String> values) {
			addCriterion("phone not in", values, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneBetween(String value1, String value2) {
			addCriterion("phone between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andPhoneNotBetween(String value1, String value2) {
			addCriterion("phone not between", value1, value2, "phone");
			return (Criteria) this;
		}

		public Criteria andStartdateIsNull() {
			addCriterion("startDate is null");
			return (Criteria) this;
		}

		public Criteria andStartdateIsNotNull() {
			addCriterion("startDate is not null");
			return (Criteria) this;
		}

		public Criteria andStartdateEqualTo(Date value) {
			addCriterion("startDate =", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateNotEqualTo(Date value) {
			addCriterion("startDate <>", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateGreaterThan(Date value) {
			addCriterion("startDate >", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
			addCriterion("startDate >=", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateLessThan(Date value) {
			addCriterion("startDate <", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateLessThanOrEqualTo(Date value) {
			addCriterion("startDate <=", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateIn(List<Date> values) {
			addCriterion("startDate in", values, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateNotIn(List<Date> values) {
			addCriterion("startDate not in", values, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateBetween(Date value1, Date value2) {
			addCriterion("startDate between", value1, value2, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateNotBetween(Date value1, Date value2) {
			addCriterion("startDate not between", value1, value2, "startdate");
			return (Criteria) this;
		}

		public Criteria andNumIsNull() {
			addCriterion("num is null");
			return (Criteria) this;
		}

		public Criteria andNumIsNotNull() {
			addCriterion("num is not null");
			return (Criteria) this;
		}

		public Criteria andNumEqualTo(Integer value) {
			addCriterion("num =", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotEqualTo(Integer value) {
			addCriterion("num <>", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumGreaterThan(Integer value) {
			addCriterion("num >", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("num >=", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLessThan(Integer value) {
			addCriterion("num <", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLessThanOrEqualTo(Integer value) {
			addCriterion("num <=", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumIn(List<Integer> values) {
			addCriterion("num in", values, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotIn(List<Integer> values) {
			addCriterion("num not in", values, "num");
			return (Criteria) this;
		}

		public Criteria andNumBetween(Integer value1, Integer value2) {
			addCriterion("num between", value1, value2, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotBetween(Integer value1, Integer value2) {
			addCriterion("num not between", value1, value2, "num");
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

		public Criteria andPhoneLikeInsensitive(String value) {
			addCriterion("upper(phone) like", value.toUpperCase(), "phone");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table mlb_verification_code
	 *
	 * @mbggenerated do_not_delete_during_merge Tue Feb 28 11:10:30 CST 2017
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
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
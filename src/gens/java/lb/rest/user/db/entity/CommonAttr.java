package lb.rest.user.db.entity;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import fc.wpf.rest.utils.CustomDateSerializer;
import fc.wpf.rest.web.bean.Tab;

@Tab(name = "common_attr")
public class CommonAttr extends CommonAttrKey {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column common_attr.attrName
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	private String attrname;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column common_attr.typeId
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	private Integer typeid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column common_attr.isAvailable
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	private Integer isavailable;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column common_attr.createTime
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	private Date createtime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column common_attr.sort
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	private Integer sort;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column common_attr.rule
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	private String rule;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column common_attr.weight
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	private Double weight;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column common_attr.attrName
	 *
	 * @return the value of common_attr.attrName
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public String getAttrname() {
		return attrname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column common_attr.attrName
	 *
	 * @param attrname
	 *            the value for common_attr.attrName
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column common_attr.typeId
	 *
	 * @return the value of common_attr.typeId
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public Integer getTypeid() {
		return typeid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column common_attr.typeId
	 *
	 * @param typeid
	 *            the value for common_attr.typeId
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column common_attr.isAvailable
	 *
	 * @return the value of common_attr.isAvailable
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public Integer getIsavailable() {
		return isavailable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column common_attr.isAvailable
	 *
	 * @param isavailable
	 *            the value for common_attr.isAvailable
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public void setIsavailable(Integer isavailable) {
		this.isavailable = isavailable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column common_attr.createTime
	 *
	 * @return the value of common_attr.createTime
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column common_attr.createTime
	 *
	 * @param createtime
	 *            the value for common_attr.createTime
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column common_attr.sort
	 *
	 * @return the value of common_attr.sort
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column common_attr.sort
	 *
	 * @param sort
	 *            the value for common_attr.sort
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column common_attr.rule
	 *
	 * @return the value of common_attr.rule
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column common_attr.rule
	 *
	 * @param rule
	 *            the value for common_attr.rule
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column common_attr.weight
	 *
	 * @return the value of common_attr.weight
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column common_attr.weight
	 *
	 * @param weight
	 *            the value for common_attr.weight
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		CommonAttr other = (CommonAttr) that;
		return (this.getAttrid() == null ? other.getAttrid() == null : this.getAttrid().equals(other.getAttrid()))
				&& (this.getAttrname() == null ? other.getAttrname() == null : this.getAttrname().equals(
						other.getAttrname()))
				&& (this.getTypeid() == null ? other.getTypeid() == null : this.getTypeid().equals(other.getTypeid()))
				&& (this.getIsavailable() == null ? other.getIsavailable() == null : this.getIsavailable().equals(
						other.getIsavailable()))
				&& (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(
						other.getCreatetime()))
				&& (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
				&& (this.getRule() == null ? other.getRule() == null : this.getRule().equals(other.getRule()))
				&& (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAttrid() == null) ? 0 : getAttrid().hashCode());
		result = prime * result + ((getAttrname() == null) ? 0 : getAttrname().hashCode());
		result = prime * result + ((getTypeid() == null) ? 0 : getTypeid().hashCode());
		result = prime * result + ((getIsavailable() == null) ? 0 : getIsavailable().hashCode());
		result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
		result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
		result = prime * result + ((getRule() == null) ? 0 : getRule().hashCode());
		result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", attrname=").append(attrname);
		sb.append(", typeid=").append(typeid);
		sb.append(", isavailable=").append(isavailable);
		sb.append(", createtime=").append(createtime);
		sb.append(", sort=").append(sort);
		sb.append(", rule=").append(rule);
		sb.append(", weight=").append(weight);
		sb.append("]");
		return sb.toString();
	}
}
package lb.rest.user.db.entity;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import fc.wpf.rest.utils.CustomDateSerializer;
import fc.wpf.rest.web.bean.Tab;

@Tab(name = "mlb_verification_code")
public class MlbVerificationCode extends MlbVerificationCodeKey {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column mlb_verification_code.phone
	 * 
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	private String phone;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column mlb_verification_code.startDate
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	private Date startdate;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column mlb_verification_code.num
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	private Integer num;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column mlb_verification_code.status
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	private Integer status;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column mlb_verification_code.phone
	 *
	 * @return the value of mlb_verification_code.phone
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column mlb_verification_code.phone
	 *
	 * @param phone
	 *            the value for mlb_verification_code.phone
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column mlb_verification_code.startDate
	 *
	 * @return the value of mlb_verification_code.startDate
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getStartdate() {
		return startdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column mlb_verification_code.startDate
	 *
	 * @param startdate
	 *            the value for mlb_verification_code.startDate
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column mlb_verification_code.num
	 *
	 * @return the value of mlb_verification_code.num
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column mlb_verification_code.num
	 *
	 * @param num
	 *            the value for mlb_verification_code.num
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column mlb_verification_code.status
	 *
	 * @return the value of mlb_verification_code.status
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column mlb_verification_code.status
	 *
	 * @param status
	 *            the value for mlb_verification_code.status
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
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
		MlbVerificationCode other = (MlbVerificationCode) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
				&& (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(
						other.getStartdate()))
				&& (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
		result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
		result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", phone=").append(phone);
		sb.append(", startdate=").append(startdate);
		sb.append(", num=").append(num);
		sb.append(", status=").append(status);
		sb.append("]");
		return sb.toString();
	}
}
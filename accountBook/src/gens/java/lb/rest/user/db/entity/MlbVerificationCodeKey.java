package lb.rest.user.db.entity;

public class MlbVerificationCodeKey {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column mlb_verification_code.id
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	private Integer id;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column mlb_verification_code.id
	 *
	 * @return the value of mlb_verification_code.id
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column mlb_verification_code.id
	 *
	 * @param id
	 *            the value for mlb_verification_code.id
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
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
		MlbVerificationCodeKey other = (MlbVerificationCodeKey) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
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
		sb.append(", id=").append(id);
		sb.append("]");
		return sb.toString();
	}
}
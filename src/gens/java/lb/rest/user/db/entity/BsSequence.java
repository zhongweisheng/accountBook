package lb.rest.user.db.entity;

public class BsSequence extends BsSequenceKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sequence.depot_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer depotId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sequence.key_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer keyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sequence.key_category
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer keyCategory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sequence.key_type
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer keyType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_sequence.key_value
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer keyValue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sequence.depot_id
     *
     * @return the value of bs_sequence.depot_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getDepotId() {
        return depotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sequence.depot_id
     *
     * @param depotId the value for bs_sequence.depot_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sequence.key_id
     *
     * @return the value of bs_sequence.key_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getKeyId() {
        return keyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sequence.key_id
     *
     * @param keyId the value for bs_sequence.key_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sequence.key_category
     *
     * @return the value of bs_sequence.key_category
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getKeyCategory() {
        return keyCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sequence.key_category
     *
     * @param keyCategory the value for bs_sequence.key_category
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setKeyCategory(Integer keyCategory) {
        this.keyCategory = keyCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sequence.key_type
     *
     * @return the value of bs_sequence.key_type
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getKeyType() {
        return keyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sequence.key_type
     *
     * @param keyType the value for bs_sequence.key_type
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setKeyType(Integer keyType) {
        this.keyType = keyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_sequence.key_value
     *
     * @return the value of bs_sequence.key_value
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getKeyValue() {
        return keyValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_sequence.key_value
     *
     * @param keyValue the value for bs_sequence.key_value
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setKeyValue(Integer keyValue) {
        this.keyValue = keyValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", depotId=").append(depotId);
        sb.append(", keyId=").append(keyId);
        sb.append(", keyCategory=").append(keyCategory);
        sb.append(", keyType=").append(keyType);
        sb.append(", keyValue=").append(keyValue);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
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
        BsSequence other = (BsSequence) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDepotId() == null ? other.getDepotId() == null : this.getDepotId().equals(other.getDepotId()))
            && (this.getKeyId() == null ? other.getKeyId() == null : this.getKeyId().equals(other.getKeyId()))
            && (this.getKeyCategory() == null ? other.getKeyCategory() == null : this.getKeyCategory().equals(other.getKeyCategory()))
            && (this.getKeyType() == null ? other.getKeyType() == null : this.getKeyType().equals(other.getKeyType()))
            && (this.getKeyValue() == null ? other.getKeyValue() == null : this.getKeyValue().equals(other.getKeyValue()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_sequence
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDepotId() == null) ? 0 : getDepotId().hashCode());
        result = prime * result + ((getKeyId() == null) ? 0 : getKeyId().hashCode());
        result = prime * result + ((getKeyCategory() == null) ? 0 : getKeyCategory().hashCode());
        result = prime * result + ((getKeyType() == null) ? 0 : getKeyType().hashCode());
        result = prime * result + ((getKeyValue() == null) ? 0 : getKeyValue().hashCode());
        return result;
    }
}
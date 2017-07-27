package lb.rest.user.db.entity;

public class SequenceKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sequence.key_id
     *
     * @mbggenerated Thu Feb 16 17:53:28 CST 2017
     */
    private Integer keyId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sequence.key_id
     *
     * @return the value of sequence.key_id
     *
     * @mbggenerated Thu Feb 16 17:53:28 CST 2017
     */
    public Integer getKeyId() {
        return keyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sequence.key_id
     *
     * @param keyId the value for sequence.key_id
     *
     * @mbggenerated Thu Feb 16 17:53:28 CST 2017
     */
    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
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
        SequenceKey other = (SequenceKey) that;
        return (this.getKeyId() == null ? other.getKeyId() == null : this.getKeyId().equals(other.getKeyId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
     *
     * @mbggenerated Thu Feb 16 17:53:28 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getKeyId() == null) ? 0 : getKeyId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence
     *
     * @mbggenerated Thu Feb 16 17:53:28 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", keyId=").append(keyId);
        sb.append("]");
        return sb.toString();
    }
}
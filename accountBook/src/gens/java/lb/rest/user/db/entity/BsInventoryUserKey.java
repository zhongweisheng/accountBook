package lb.rest.user.db.entity;

public class BsInventoryUserKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.user_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.user_id
     *
     * @return the value of bs_inventory_user.user_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.user_id
     *
     * @param userId the value for bs_inventory_user.user_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
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
        BsInventoryUserKey other = (BsInventoryUserKey) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}
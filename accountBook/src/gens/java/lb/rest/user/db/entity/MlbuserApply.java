package lb.rest.user.db.entity;

import fc.wpf.rest.utils.CustomDateSerializer;
import fc.wpf.rest.web.bean.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="mlbuser_apply")
public class MlbuserApply extends MlbuserApplyKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_apply.mlbuser_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer mlbuserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_apply.mlbuser_Name
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String mlbuserName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_apply.ht_user_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer htUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_apply.ht_user_name
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String htUserName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_apply.mlbuser_id
     *
     * @return the value of mlbuser_apply.mlbuser_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getMlbuserId() {
        return mlbuserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_apply.mlbuser_id
     *
     * @param mlbuserId the value for mlbuser_apply.mlbuser_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setMlbuserId(Integer mlbuserId) {
        this.mlbuserId = mlbuserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_apply.mlbuser_Name
     *
     * @return the value of mlbuser_apply.mlbuser_Name
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getMlbuserName() {
        return mlbuserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_apply.mlbuser_Name
     *
     * @param mlbuserName the value for mlbuser_apply.mlbuser_Name
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setMlbuserName(String mlbuserName) {
        this.mlbuserName = mlbuserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_apply.ht_user_id
     *
     * @return the value of mlbuser_apply.ht_user_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getHtUserId() {
        return htUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_apply.ht_user_id
     *
     * @param htUserId the value for mlbuser_apply.ht_user_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setHtUserId(Integer htUserId) {
        this.htUserId = htUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_apply.ht_user_name
     *
     * @return the value of mlbuser_apply.ht_user_name
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getHtUserName() {
        return htUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_apply.ht_user_name
     *
     * @param htUserName the value for mlbuser_apply.ht_user_name
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setHtUserName(String htUserName) {
        this.htUserName = htUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_apply
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
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
        MlbuserApply other = (MlbuserApply) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMlbuserId() == null ? other.getMlbuserId() == null : this.getMlbuserId().equals(other.getMlbuserId()))
            && (this.getMlbuserName() == null ? other.getMlbuserName() == null : this.getMlbuserName().equals(other.getMlbuserName()))
            && (this.getHtUserId() == null ? other.getHtUserId() == null : this.getHtUserId().equals(other.getHtUserId()))
            && (this.getHtUserName() == null ? other.getHtUserName() == null : this.getHtUserName().equals(other.getHtUserName()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_apply
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMlbuserId() == null) ? 0 : getMlbuserId().hashCode());
        result = prime * result + ((getMlbuserName() == null) ? 0 : getMlbuserName().hashCode());
        result = prime * result + ((getHtUserId() == null) ? 0 : getHtUserId().hashCode());
        result = prime * result + ((getHtUserName() == null) ? 0 : getHtUserName().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_apply
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mlbuserId=").append(mlbuserId);
        sb.append(", mlbuserName=").append(mlbuserName);
        sb.append(", htUserId=").append(htUserId);
        sb.append(", htUserName=").append(htUserName);
        sb.append("]");
        return sb.toString();
    }
}
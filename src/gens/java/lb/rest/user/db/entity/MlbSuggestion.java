package lb.rest.user.db.entity;

import fc.wpf.rest.utils.CustomDateSerializer;
import fc.wpf.rest.web.bean.Tab;
import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="mlb_suggestion")
public class MlbSuggestion extends MlbSuggestionKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlb_suggestion.mlbUserId
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer mlbuserid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlb_suggestion.mlbUserName
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String mlbusername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlb_suggestion.status
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlb_suggestion.suggestion_time
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Date suggestionTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlb_suggestion.remark
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlb_suggestion.deal_time
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Date dealTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlb_suggestion.deal_user
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer dealUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlb_suggestion.reply_msg
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String replyMsg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlb_suggestion.mlbUserId
     *
     * @return the value of mlb_suggestion.mlbUserId
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getMlbuserid() {
        return mlbuserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlb_suggestion.mlbUserId
     *
     * @param mlbuserid the value for mlb_suggestion.mlbUserId
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setMlbuserid(Integer mlbuserid) {
        this.mlbuserid = mlbuserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlb_suggestion.mlbUserName
     *
     * @return the value of mlb_suggestion.mlbUserName
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getMlbusername() {
        return mlbusername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlb_suggestion.mlbUserName
     *
     * @param mlbusername the value for mlb_suggestion.mlbUserName
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setMlbusername(String mlbusername) {
        this.mlbusername = mlbusername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlb_suggestion.status
     *
     * @return the value of mlb_suggestion.status
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlb_suggestion.status
     *
     * @param status the value for mlb_suggestion.status
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlb_suggestion.suggestion_time
     *
     * @return the value of mlb_suggestion.suggestion_time
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getSuggestionTime() {
        return suggestionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlb_suggestion.suggestion_time
     *
     * @param suggestionTime the value for mlb_suggestion.suggestion_time
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setSuggestionTime(Date suggestionTime) {
        this.suggestionTime = suggestionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlb_suggestion.remark
     *
     * @return the value of mlb_suggestion.remark
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlb_suggestion.remark
     *
     * @param remark the value for mlb_suggestion.remark
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlb_suggestion.deal_time
     *
     * @return the value of mlb_suggestion.deal_time
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlb_suggestion.deal_time
     *
     * @param dealTime the value for mlb_suggestion.deal_time
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlb_suggestion.deal_user
     *
     * @return the value of mlb_suggestion.deal_user
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getDealUser() {
        return dealUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlb_suggestion.deal_user
     *
     * @param dealUser the value for mlb_suggestion.deal_user
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setDealUser(Integer dealUser) {
        this.dealUser = dealUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlb_suggestion.reply_msg
     *
     * @return the value of mlb_suggestion.reply_msg
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getReplyMsg() {
        return replyMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlb_suggestion.reply_msg
     *
     * @param replyMsg the value for mlb_suggestion.reply_msg
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setReplyMsg(String replyMsg) {
        this.replyMsg = replyMsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
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
        MlbSuggestion other = (MlbSuggestion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMlbuserid() == null ? other.getMlbuserid() == null : this.getMlbuserid().equals(other.getMlbuserid()))
            && (this.getMlbusername() == null ? other.getMlbusername() == null : this.getMlbusername().equals(other.getMlbusername()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSuggestionTime() == null ? other.getSuggestionTime() == null : this.getSuggestionTime().equals(other.getSuggestionTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()))
            && (this.getDealUser() == null ? other.getDealUser() == null : this.getDealUser().equals(other.getDealUser()))
            && (this.getReplyMsg() == null ? other.getReplyMsg() == null : this.getReplyMsg().equals(other.getReplyMsg()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMlbuserid() == null) ? 0 : getMlbuserid().hashCode());
        result = prime * result + ((getMlbusername() == null) ? 0 : getMlbusername().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSuggestionTime() == null) ? 0 : getSuggestionTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        result = prime * result + ((getDealUser() == null) ? 0 : getDealUser().hashCode());
        result = prime * result + ((getReplyMsg() == null) ? 0 : getReplyMsg().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_suggestion
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mlbuserid=").append(mlbuserid);
        sb.append(", mlbusername=").append(mlbusername);
        sb.append(", status=").append(status);
        sb.append(", suggestionTime=").append(suggestionTime);
        sb.append(", remark=").append(remark);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", dealUser=").append(dealUser);
        sb.append(", replyMsg=").append(replyMsg);
        sb.append("]");
        return sb.toString();
    }
}
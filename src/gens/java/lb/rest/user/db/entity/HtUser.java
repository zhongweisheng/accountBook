package lb.rest.user.db.entity;

import fc.wpf.rest.utils.CustomDateSerializer;
import fc.wpf.rest.web.bean.Tab;
import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="ht_user")
public class HtUser extends HtUserKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.userName
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.userPwd
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private String userpwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.userType
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private Integer usertype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.realName
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private String realname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.departmentId
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private Integer departmentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.isAvailable
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private Integer isavailable;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.cellphone
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private String cellphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.email
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.creator
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private Integer creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.createTime
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.openid
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ht_user.qy_user_id
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    private String qyUserId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.userName
     *
     * @return the value of ht_user.userName
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.userName
     *
     * @param username the value for ht_user.userName
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.userPwd
     *
     * @return the value of ht_user.userPwd
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public String getUserpwd() {
        return userpwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.userPwd
     *
     * @param userpwd the value for ht_user.userPwd
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.userType
     *
     * @return the value of ht_user.userType
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.userType
     *
     * @param usertype the value for ht_user.userType
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.realName
     *
     * @return the value of ht_user.realName
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.realName
     *
     * @param realname the value for ht_user.realName
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.departmentId
     *
     * @return the value of ht_user.departmentId
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public Integer getDepartmentid() {
        return departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.departmentId
     *
     * @param departmentid the value for ht_user.departmentId
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.isAvailable
     *
     * @return the value of ht_user.isAvailable
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public Integer getIsavailable() {
        return isavailable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.isAvailable
     *
     * @param isavailable the value for ht_user.isAvailable
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setIsavailable(Integer isavailable) {
        this.isavailable = isavailable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.cellphone
     *
     * @return the value of ht_user.cellphone
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.cellphone
     *
     * @param cellphone the value for ht_user.cellphone
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.email
     *
     * @return the value of ht_user.email
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.email
     *
     * @param email the value for ht_user.email
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.creator
     *
     * @return the value of ht_user.creator
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.creator
     *
     * @param creator the value for ht_user.creator
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.createTime
     *
     * @return the value of ht_user.createTime
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.createTime
     *
     * @param createtime the value for ht_user.createTime
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.openid
     *
     * @return the value of ht_user.openid
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.openid
     *
     * @param openid the value for ht_user.openid
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ht_user.qy_user_id
     *
     * @return the value of ht_user.qy_user_id
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public String getQyUserId() {
        return qyUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ht_user.qy_user_id
     *
     * @param qyUserId the value for ht_user.qy_user_id
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    public void setQyUserId(String qyUserId) {
        this.qyUserId = qyUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
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
        HtUser other = (HtUser) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserpwd() == null ? other.getUserpwd() == null : this.getUserpwd().equals(other.getUserpwd()))
            && (this.getUsertype() == null ? other.getUsertype() == null : this.getUsertype().equals(other.getUsertype()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getDepartmentid() == null ? other.getDepartmentid() == null : this.getDepartmentid().equals(other.getDepartmentid()))
            && (this.getIsavailable() == null ? other.getIsavailable() == null : this.getIsavailable().equals(other.getIsavailable()))
            && (this.getCellphone() == null ? other.getCellphone() == null : this.getCellphone().equals(other.getCellphone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getQyUserId() == null ? other.getQyUserId() == null : this.getQyUserId().equals(other.getQyUserId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserpwd() == null) ? 0 : getUserpwd().hashCode());
        result = prime * result + ((getUsertype() == null) ? 0 : getUsertype().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
        result = prime * result + ((getIsavailable() == null) ? 0 : getIsavailable().hashCode());
        result = prime * result + ((getCellphone() == null) ? 0 : getCellphone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getQyUserId() == null) ? 0 : getQyUserId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ht_user
     *
     * @mbggenerated Fri Feb 24 18:06:20 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", userpwd=").append(userpwd);
        sb.append(", usertype=").append(usertype);
        sb.append(", realname=").append(realname);
        sb.append(", departmentid=").append(departmentid);
        sb.append(", isavailable=").append(isavailable);
        sb.append(", cellphone=").append(cellphone);
        sb.append(", email=").append(email);
        sb.append(", creator=").append(creator);
        sb.append(", createtime=").append(createtime);
        sb.append(", openid=").append(openid);
        sb.append(", qyUserId=").append(qyUserId);
        sb.append("]");
        return sb.toString();
    }
}
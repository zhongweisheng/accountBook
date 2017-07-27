package lb.rest.user.db.entity;

import java.util.Date;

public class BsInventoryUser extends BsInventoryUserKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.true_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String trueName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.phone
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.login_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String loginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.pass_word
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String passWord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.location
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer location;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.location_desc
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String locationDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.address
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.openid
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.nick_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.user_image
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String userImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.reg_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Date regTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.update_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.remark
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.print_head
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String printHead;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.bs_number_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer bsNumberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.user_type
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer userType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.company_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.owner_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer ownerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.is_actived
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer isActived;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.is_deleted
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_user.depot_count
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer depotCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.true_name
     *
     * @return the value of bs_inventory_user.true_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.true_name
     *
     * @param trueName the value for bs_inventory_user.true_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.phone
     *
     * @return the value of bs_inventory_user.phone
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.phone
     *
     * @param phone the value for bs_inventory_user.phone
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.login_name
     *
     * @return the value of bs_inventory_user.login_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.login_name
     *
     * @param loginName the value for bs_inventory_user.login_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.pass_word
     *
     * @return the value of bs_inventory_user.pass_word
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.pass_word
     *
     * @param passWord the value for bs_inventory_user.pass_word
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.location
     *
     * @return the value of bs_inventory_user.location
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.location
     *
     * @param location the value for bs_inventory_user.location
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setLocation(Integer location) {
        this.location = location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.location_desc
     *
     * @return the value of bs_inventory_user.location_desc
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getLocationDesc() {
        return locationDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.location_desc
     *
     * @param locationDesc the value for bs_inventory_user.location_desc
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc == null ? null : locationDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.address
     *
     * @return the value of bs_inventory_user.address
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.address
     *
     * @param address the value for bs_inventory_user.address
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.openid
     *
     * @return the value of bs_inventory_user.openid
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.openid
     *
     * @param openid the value for bs_inventory_user.openid
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.nick_name
     *
     * @return the value of bs_inventory_user.nick_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.nick_name
     *
     * @param nickName the value for bs_inventory_user.nick_name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.user_image
     *
     * @return the value of bs_inventory_user.user_image
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.user_image
     *
     * @param userImage the value for bs_inventory_user.user_image
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.reg_time
     *
     * @return the value of bs_inventory_user.reg_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.reg_time
     *
     * @param regTime the value for bs_inventory_user.reg_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.update_time
     *
     * @return the value of bs_inventory_user.update_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.update_time
     *
     * @param updateTime the value for bs_inventory_user.update_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.remark
     *
     * @return the value of bs_inventory_user.remark
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.remark
     *
     * @param remark the value for bs_inventory_user.remark
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.print_head
     *
     * @return the value of bs_inventory_user.print_head
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getPrintHead() {
        return printHead;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.print_head
     *
     * @param printHead the value for bs_inventory_user.print_head
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setPrintHead(String printHead) {
        this.printHead = printHead == null ? null : printHead.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.bs_number_id
     *
     * @return the value of bs_inventory_user.bs_number_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getBsNumberId() {
        return bsNumberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.bs_number_id
     *
     * @param bsNumberId the value for bs_inventory_user.bs_number_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setBsNumberId(Integer bsNumberId) {
        this.bsNumberId = bsNumberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.user_type
     *
     * @return the value of bs_inventory_user.user_type
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.user_type
     *
     * @param userType the value for bs_inventory_user.user_type
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.company_id
     *
     * @return the value of bs_inventory_user.company_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.company_id
     *
     * @param companyId the value for bs_inventory_user.company_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.owner_id
     *
     * @return the value of bs_inventory_user.owner_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.owner_id
     *
     * @param ownerId the value for bs_inventory_user.owner_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.is_actived
     *
     * @return the value of bs_inventory_user.is_actived
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getIsActived() {
        return isActived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.is_actived
     *
     * @param isActived the value for bs_inventory_user.is_actived
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setIsActived(Integer isActived) {
        this.isActived = isActived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.is_deleted
     *
     * @return the value of bs_inventory_user.is_deleted
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.is_deleted
     *
     * @param isDeleted the value for bs_inventory_user.is_deleted
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_user.depot_count
     *
     * @return the value of bs_inventory_user.depot_count
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getDepotCount() {
        return depotCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_user.depot_count
     *
     * @param depotCount the value for bs_inventory_user.depot_count
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setDepotCount(Integer depotCount) {
        this.depotCount = depotCount;
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
        sb.append(", trueName=").append(trueName);
        sb.append(", phone=").append(phone);
        sb.append(", loginName=").append(loginName);
        sb.append(", passWord=").append(passWord);
        sb.append(", location=").append(location);
        sb.append(", locationDesc=").append(locationDesc);
        sb.append(", address=").append(address);
        sb.append(", openid=").append(openid);
        sb.append(", nickName=").append(nickName);
        sb.append(", userImage=").append(userImage);
        sb.append(", regTime=").append(regTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", printHead=").append(printHead);
        sb.append(", bsNumberId=").append(bsNumberId);
        sb.append(", userType=").append(userType);
        sb.append(", companyId=").append(companyId);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", isActived=").append(isActived);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", depotCount=").append(depotCount);
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
        BsInventoryUser other = (BsInventoryUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTrueName() == null ? other.getTrueName() == null : this.getTrueName().equals(other.getTrueName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getPassWord() == null ? other.getPassWord() == null : this.getPassWord().equals(other.getPassWord()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getLocationDesc() == null ? other.getLocationDesc() == null : this.getLocationDesc().equals(other.getLocationDesc()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getUserImage() == null ? other.getUserImage() == null : this.getUserImage().equals(other.getUserImage()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPrintHead() == null ? other.getPrintHead() == null : this.getPrintHead().equals(other.getPrintHead()))
            && (this.getBsNumberId() == null ? other.getBsNumberId() == null : this.getBsNumberId().equals(other.getBsNumberId()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getIsActived() == null ? other.getIsActived() == null : this.getIsActived().equals(other.getIsActived()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getDepotCount() == null ? other.getDepotCount() == null : this.getDepotCount().equals(other.getDepotCount()));
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
        result = prime * result + ((getTrueName() == null) ? 0 : getTrueName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPassWord() == null) ? 0 : getPassWord().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getLocationDesc() == null) ? 0 : getLocationDesc().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getUserImage() == null) ? 0 : getUserImage().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPrintHead() == null) ? 0 : getPrintHead().hashCode());
        result = prime * result + ((getBsNumberId() == null) ? 0 : getBsNumberId().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getIsActived() == null) ? 0 : getIsActived().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getDepotCount() == null) ? 0 : getDepotCount().hashCode());
        return result;
    }
}
package lb.rest.user.db.entity;

import java.util.Date;

public class BsInventoryStoragePay extends BsInventoryStoragePayKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.storage_id
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Integer storageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.settle_count
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Double settleCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.settle_price
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Double settlePrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.settle_money
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Double settleMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.should_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Double shouldPay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.actual_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Double actualPay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.create_time
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.update_time
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.operate_user_id
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Integer operateUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.operate_user_name
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private String operateUserName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_storage_pay.is_deleted
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    private Integer isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.storage_id
     *
     * @return the value of bs_inventory_storage_pay.storage_id
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Integer getStorageId() {
        return storageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.storage_id
     *
     * @param storageId the value for bs_inventory_storage_pay.storage_id
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.settle_count
     *
     * @return the value of bs_inventory_storage_pay.settle_count
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Double getSettleCount() {
        return settleCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.settle_count
     *
     * @param settleCount the value for bs_inventory_storage_pay.settle_count
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setSettleCount(Double settleCount) {
        this.settleCount = settleCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.settle_price
     *
     * @return the value of bs_inventory_storage_pay.settle_price
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Double getSettlePrice() {
        return settlePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.settle_price
     *
     * @param settlePrice the value for bs_inventory_storage_pay.settle_price
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setSettlePrice(Double settlePrice) {
        this.settlePrice = settlePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.settle_money
     *
     * @return the value of bs_inventory_storage_pay.settle_money
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Double getSettleMoney() {
        return settleMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.settle_money
     *
     * @param settleMoney the value for bs_inventory_storage_pay.settle_money
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setSettleMoney(Double settleMoney) {
        this.settleMoney = settleMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.should_pay
     *
     * @return the value of bs_inventory_storage_pay.should_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Double getShouldPay() {
        return shouldPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.should_pay
     *
     * @param shouldPay the value for bs_inventory_storage_pay.should_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setShouldPay(Double shouldPay) {
        this.shouldPay = shouldPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.actual_pay
     *
     * @return the value of bs_inventory_storage_pay.actual_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Double getActualPay() {
        return actualPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.actual_pay
     *
     * @param actualPay the value for bs_inventory_storage_pay.actual_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.create_time
     *
     * @return the value of bs_inventory_storage_pay.create_time
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.create_time
     *
     * @param createTime the value for bs_inventory_storage_pay.create_time
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.update_time
     *
     * @return the value of bs_inventory_storage_pay.update_time
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.update_time
     *
     * @param updateTime the value for bs_inventory_storage_pay.update_time
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.operate_user_id
     *
     * @return the value of bs_inventory_storage_pay.operate_user_id
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Integer getOperateUserId() {
        return operateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.operate_user_id
     *
     * @param operateUserId the value for bs_inventory_storage_pay.operate_user_id
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setOperateUserId(Integer operateUserId) {
        this.operateUserId = operateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.operate_user_name
     *
     * @return the value of bs_inventory_storage_pay.operate_user_name
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public String getOperateUserName() {
        return operateUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.operate_user_name
     *
     * @param operateUserName the value for bs_inventory_storage_pay.operate_user_name
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setOperateUserName(String operateUserName) {
        this.operateUserName = operateUserName == null ? null : operateUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_storage_pay.is_deleted
     *
     * @return the value of bs_inventory_storage_pay.is_deleted
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_storage_pay.is_deleted
     *
     * @param isDeleted the value for bs_inventory_storage_pay.is_deleted
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", storageId=").append(storageId);
        sb.append(", settleCount=").append(settleCount);
        sb.append(", settlePrice=").append(settlePrice);
        sb.append(", settleMoney=").append(settleMoney);
        sb.append(", shouldPay=").append(shouldPay);
        sb.append(", actualPay=").append(actualPay);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", operateUserId=").append(operateUserId);
        sb.append(", operateUserName=").append(operateUserName);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
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
        BsInventoryStoragePay other = (BsInventoryStoragePay) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStorageId() == null ? other.getStorageId() == null : this.getStorageId().equals(other.getStorageId()))
            && (this.getSettleCount() == null ? other.getSettleCount() == null : this.getSettleCount().equals(other.getSettleCount()))
            && (this.getSettlePrice() == null ? other.getSettlePrice() == null : this.getSettlePrice().equals(other.getSettlePrice()))
            && (this.getSettleMoney() == null ? other.getSettleMoney() == null : this.getSettleMoney().equals(other.getSettleMoney()))
            && (this.getShouldPay() == null ? other.getShouldPay() == null : this.getShouldPay().equals(other.getShouldPay()))
            && (this.getActualPay() == null ? other.getActualPay() == null : this.getActualPay().equals(other.getActualPay()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperateUserId() == null ? other.getOperateUserId() == null : this.getOperateUserId().equals(other.getOperateUserId()))
            && (this.getOperateUserName() == null ? other.getOperateUserName() == null : this.getOperateUserName().equals(other.getOperateUserName()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStorageId() == null) ? 0 : getStorageId().hashCode());
        result = prime * result + ((getSettleCount() == null) ? 0 : getSettleCount().hashCode());
        result = prime * result + ((getSettlePrice() == null) ? 0 : getSettlePrice().hashCode());
        result = prime * result + ((getSettleMoney() == null) ? 0 : getSettleMoney().hashCode());
        result = prime * result + ((getShouldPay() == null) ? 0 : getShouldPay().hashCode());
        result = prime * result + ((getActualPay() == null) ? 0 : getActualPay().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperateUserId() == null) ? 0 : getOperateUserId().hashCode());
        result = prime * result + ((getOperateUserName() == null) ? 0 : getOperateUserName().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}
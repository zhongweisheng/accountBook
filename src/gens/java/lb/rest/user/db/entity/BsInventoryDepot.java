package lb.rest.user.db.entity;

import java.util.Date;

public class BsInventoryDepot extends BsInventoryDepotKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.owner_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer ownerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.company_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.address
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.storage_capacity_str
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String storageCapacityStr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.storage_capacity
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Double storageCapacity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.remark
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.create_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.update_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.is_deleted
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.int_column1
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer intColumn1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.int_column2
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private Integer intColumn2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.str_column1
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String strColumn1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_inventory_depot.str_column2
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    private String strColumn2;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.owner_id
     *
     * @return the value of bs_inventory_depot.owner_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.owner_id
     *
     * @param ownerId the value for bs_inventory_depot.owner_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.company_id
     *
     * @return the value of bs_inventory_depot.company_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.company_id
     *
     * @param companyId the value for bs_inventory_depot.company_id
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.name
     *
     * @return the value of bs_inventory_depot.name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.name
     *
     * @param name the value for bs_inventory_depot.name
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.address
     *
     * @return the value of bs_inventory_depot.address
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.address
     *
     * @param address the value for bs_inventory_depot.address
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.storage_capacity_str
     *
     * @return the value of bs_inventory_depot.storage_capacity_str
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getStorageCapacityStr() {
        return storageCapacityStr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.storage_capacity_str
     *
     * @param storageCapacityStr the value for bs_inventory_depot.storage_capacity_str
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setStorageCapacityStr(String storageCapacityStr) {
        this.storageCapacityStr = storageCapacityStr == null ? null : storageCapacityStr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.storage_capacity
     *
     * @return the value of bs_inventory_depot.storage_capacity
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Double getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.storage_capacity
     *
     * @param storageCapacity the value for bs_inventory_depot.storage_capacity
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setStorageCapacity(Double storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.remark
     *
     * @return the value of bs_inventory_depot.remark
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.remark
     *
     * @param remark the value for bs_inventory_depot.remark
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.create_time
     *
     * @return the value of bs_inventory_depot.create_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.create_time
     *
     * @param createTime the value for bs_inventory_depot.create_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.update_time
     *
     * @return the value of bs_inventory_depot.update_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.update_time
     *
     * @param updateTime the value for bs_inventory_depot.update_time
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.is_deleted
     *
     * @return the value of bs_inventory_depot.is_deleted
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.is_deleted
     *
     * @param isDeleted the value for bs_inventory_depot.is_deleted
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.int_column1
     *
     * @return the value of bs_inventory_depot.int_column1
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getIntColumn1() {
        return intColumn1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.int_column1
     *
     * @param intColumn1 the value for bs_inventory_depot.int_column1
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setIntColumn1(Integer intColumn1) {
        this.intColumn1 = intColumn1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.int_column2
     *
     * @return the value of bs_inventory_depot.int_column2
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public Integer getIntColumn2() {
        return intColumn2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.int_column2
     *
     * @param intColumn2 the value for bs_inventory_depot.int_column2
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setIntColumn2(Integer intColumn2) {
        this.intColumn2 = intColumn2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.str_column1
     *
     * @return the value of bs_inventory_depot.str_column1
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getStrColumn1() {
        return strColumn1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.str_column1
     *
     * @param strColumn1 the value for bs_inventory_depot.str_column1
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setStrColumn1(String strColumn1) {
        this.strColumn1 = strColumn1 == null ? null : strColumn1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_inventory_depot.str_column2
     *
     * @return the value of bs_inventory_depot.str_column2
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public String getStrColumn2() {
        return strColumn2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_inventory_depot.str_column2
     *
     * @param strColumn2 the value for bs_inventory_depot.str_column2
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    public void setStrColumn2(String strColumn2) {
        this.strColumn2 = strColumn2 == null ? null : strColumn2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_depot
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ownerId=").append(ownerId);
        sb.append(", companyId=").append(companyId);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", storageCapacityStr=").append(storageCapacityStr);
        sb.append(", storageCapacity=").append(storageCapacity);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", intColumn1=").append(intColumn1);
        sb.append(", intColumn2=").append(intColumn2);
        sb.append(", strColumn1=").append(strColumn1);
        sb.append(", strColumn2=").append(strColumn2);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_depot
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
        BsInventoryDepot other = (BsInventoryDepot) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOwnerId() == null ? other.getOwnerId() == null : this.getOwnerId().equals(other.getOwnerId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getStorageCapacityStr() == null ? other.getStorageCapacityStr() == null : this.getStorageCapacityStr().equals(other.getStorageCapacityStr()))
            && (this.getStorageCapacity() == null ? other.getStorageCapacity() == null : this.getStorageCapacity().equals(other.getStorageCapacity()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getIntColumn1() == null ? other.getIntColumn1() == null : this.getIntColumn1().equals(other.getIntColumn1()))
            && (this.getIntColumn2() == null ? other.getIntColumn2() == null : this.getIntColumn2().equals(other.getIntColumn2()))
            && (this.getStrColumn1() == null ? other.getStrColumn1() == null : this.getStrColumn1().equals(other.getStrColumn1()))
            && (this.getStrColumn2() == null ? other.getStrColumn2() == null : this.getStrColumn2().equals(other.getStrColumn2()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_depot
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOwnerId() == null) ? 0 : getOwnerId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getStorageCapacityStr() == null) ? 0 : getStorageCapacityStr().hashCode());
        result = prime * result + ((getStorageCapacity() == null) ? 0 : getStorageCapacity().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getIntColumn1() == null) ? 0 : getIntColumn1().hashCode());
        result = prime * result + ((getIntColumn2() == null) ? 0 : getIntColumn2().hashCode());
        result = prime * result + ((getStrColumn1() == null) ? 0 : getStrColumn1().hashCode());
        result = prime * result + ((getStrColumn2() == null) ? 0 : getStrColumn2().hashCode());
        return result;
    }
}
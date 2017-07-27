package lb.rest.user.db.entity;

import fc.wpf.rest.utils.CustomDateSerializer;
import fc.wpf.rest.web.bean.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="mlbuser_warehouse")
public class MlbuserWarehouse extends MlbuserWarehouseKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.user_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.warename
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String warename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.wareaddress
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String wareaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.warelocation
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer warelocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.warelocationDesc
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String warelocationdesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.has_invoice
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer hasInvoice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.has_tower
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private Integer hasTower;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.out_put_num
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String outPutNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.field_scale
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String fieldScale;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.year_turnover
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String yearTurnover;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.main_flow_direction
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String mainFlowDirection;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.operate_year_limit
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String operateYearLimit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.property_right
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String propertyRight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_warehouse.isStorage
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    private String isstorage;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.user_id
     *
     * @return the value of mlbuser_warehouse.user_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.user_id
     *
     * @param userId the value for mlbuser_warehouse.user_id
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.warename
     *
     * @return the value of mlbuser_warehouse.warename
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getWarename() {
        return warename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.warename
     *
     * @param warename the value for mlbuser_warehouse.warename
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setWarename(String warename) {
        this.warename = warename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.wareaddress
     *
     * @return the value of mlbuser_warehouse.wareaddress
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getWareaddress() {
        return wareaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.wareaddress
     *
     * @param wareaddress the value for mlbuser_warehouse.wareaddress
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setWareaddress(String wareaddress) {
        this.wareaddress = wareaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.warelocation
     *
     * @return the value of mlbuser_warehouse.warelocation
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getWarelocation() {
        return warelocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.warelocation
     *
     * @param warelocation the value for mlbuser_warehouse.warelocation
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setWarelocation(Integer warelocation) {
        this.warelocation = warelocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.warelocationDesc
     *
     * @return the value of mlbuser_warehouse.warelocationDesc
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getWarelocationdesc() {
        return warelocationdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.warelocationDesc
     *
     * @param warelocationdesc the value for mlbuser_warehouse.warelocationDesc
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setWarelocationdesc(String warelocationdesc) {
        this.warelocationdesc = warelocationdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.has_invoice
     *
     * @return the value of mlbuser_warehouse.has_invoice
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getHasInvoice() {
        return hasInvoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.has_invoice
     *
     * @param hasInvoice the value for mlbuser_warehouse.has_invoice
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setHasInvoice(Integer hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.has_tower
     *
     * @return the value of mlbuser_warehouse.has_tower
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public Integer getHasTower() {
        return hasTower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.has_tower
     *
     * @param hasTower the value for mlbuser_warehouse.has_tower
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setHasTower(Integer hasTower) {
        this.hasTower = hasTower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.out_put_num
     *
     * @return the value of mlbuser_warehouse.out_put_num
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getOutPutNum() {
        return outPutNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.out_put_num
     *
     * @param outPutNum the value for mlbuser_warehouse.out_put_num
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setOutPutNum(String outPutNum) {
        this.outPutNum = outPutNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.field_scale
     *
     * @return the value of mlbuser_warehouse.field_scale
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getFieldScale() {
        return fieldScale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.field_scale
     *
     * @param fieldScale the value for mlbuser_warehouse.field_scale
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setFieldScale(String fieldScale) {
        this.fieldScale = fieldScale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.year_turnover
     *
     * @return the value of mlbuser_warehouse.year_turnover
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getYearTurnover() {
        return yearTurnover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.year_turnover
     *
     * @param yearTurnover the value for mlbuser_warehouse.year_turnover
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setYearTurnover(String yearTurnover) {
        this.yearTurnover = yearTurnover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.main_flow_direction
     *
     * @return the value of mlbuser_warehouse.main_flow_direction
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getMainFlowDirection() {
        return mainFlowDirection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.main_flow_direction
     *
     * @param mainFlowDirection the value for mlbuser_warehouse.main_flow_direction
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setMainFlowDirection(String mainFlowDirection) {
        this.mainFlowDirection = mainFlowDirection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.operate_year_limit
     *
     * @return the value of mlbuser_warehouse.operate_year_limit
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getOperateYearLimit() {
        return operateYearLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.operate_year_limit
     *
     * @param operateYearLimit the value for mlbuser_warehouse.operate_year_limit
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setOperateYearLimit(String operateYearLimit) {
        this.operateYearLimit = operateYearLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.property_right
     *
     * @return the value of mlbuser_warehouse.property_right
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getPropertyRight() {
        return propertyRight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.property_right
     *
     * @param propertyRight the value for mlbuser_warehouse.property_right
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setPropertyRight(String propertyRight) {
        this.propertyRight = propertyRight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_warehouse.isStorage
     *
     * @return the value of mlbuser_warehouse.isStorage
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String getIsstorage() {
        return isstorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_warehouse.isStorage
     *
     * @param isstorage the value for mlbuser_warehouse.isStorage
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public void setIsstorage(String isstorage) {
        this.isstorage = isstorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
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
        MlbuserWarehouse other = (MlbuserWarehouse) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getWarename() == null ? other.getWarename() == null : this.getWarename().equals(other.getWarename()))
            && (this.getWareaddress() == null ? other.getWareaddress() == null : this.getWareaddress().equals(other.getWareaddress()))
            && (this.getWarelocation() == null ? other.getWarelocation() == null : this.getWarelocation().equals(other.getWarelocation()))
            && (this.getWarelocationdesc() == null ? other.getWarelocationdesc() == null : this.getWarelocationdesc().equals(other.getWarelocationdesc()))
            && (this.getHasInvoice() == null ? other.getHasInvoice() == null : this.getHasInvoice().equals(other.getHasInvoice()))
            && (this.getHasTower() == null ? other.getHasTower() == null : this.getHasTower().equals(other.getHasTower()))
            && (this.getOutPutNum() == null ? other.getOutPutNum() == null : this.getOutPutNum().equals(other.getOutPutNum()))
            && (this.getFieldScale() == null ? other.getFieldScale() == null : this.getFieldScale().equals(other.getFieldScale()))
            && (this.getYearTurnover() == null ? other.getYearTurnover() == null : this.getYearTurnover().equals(other.getYearTurnover()))
            && (this.getMainFlowDirection() == null ? other.getMainFlowDirection() == null : this.getMainFlowDirection().equals(other.getMainFlowDirection()))
            && (this.getOperateYearLimit() == null ? other.getOperateYearLimit() == null : this.getOperateYearLimit().equals(other.getOperateYearLimit()))
            && (this.getPropertyRight() == null ? other.getPropertyRight() == null : this.getPropertyRight().equals(other.getPropertyRight()))
            && (this.getIsstorage() == null ? other.getIsstorage() == null : this.getIsstorage().equals(other.getIsstorage()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getWarename() == null) ? 0 : getWarename().hashCode());
        result = prime * result + ((getWareaddress() == null) ? 0 : getWareaddress().hashCode());
        result = prime * result + ((getWarelocation() == null) ? 0 : getWarelocation().hashCode());
        result = prime * result + ((getWarelocationdesc() == null) ? 0 : getWarelocationdesc().hashCode());
        result = prime * result + ((getHasInvoice() == null) ? 0 : getHasInvoice().hashCode());
        result = prime * result + ((getHasTower() == null) ? 0 : getHasTower().hashCode());
        result = prime * result + ((getOutPutNum() == null) ? 0 : getOutPutNum().hashCode());
        result = prime * result + ((getFieldScale() == null) ? 0 : getFieldScale().hashCode());
        result = prime * result + ((getYearTurnover() == null) ? 0 : getYearTurnover().hashCode());
        result = prime * result + ((getMainFlowDirection() == null) ? 0 : getMainFlowDirection().hashCode());
        result = prime * result + ((getOperateYearLimit() == null) ? 0 : getOperateYearLimit().hashCode());
        result = prime * result + ((getPropertyRight() == null) ? 0 : getPropertyRight().hashCode());
        result = prime * result + ((getIsstorage() == null) ? 0 : getIsstorage().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", warename=").append(warename);
        sb.append(", wareaddress=").append(wareaddress);
        sb.append(", warelocation=").append(warelocation);
        sb.append(", warelocationdesc=").append(warelocationdesc);
        sb.append(", hasInvoice=").append(hasInvoice);
        sb.append(", hasTower=").append(hasTower);
        sb.append(", outPutNum=").append(outPutNum);
        sb.append(", fieldScale=").append(fieldScale);
        sb.append(", yearTurnover=").append(yearTurnover);
        sb.append(", mainFlowDirection=").append(mainFlowDirection);
        sb.append(", operateYearLimit=").append(operateYearLimit);
        sb.append(", propertyRight=").append(propertyRight);
        sb.append(", isstorage=").append(isstorage);
        sb.append("]");
        return sb.toString();
    }
}
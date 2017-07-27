package lb.rest.user.db.entity;

import java.util.Date;

public class BsNumber extends BsNumberKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_number.name
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_number.phone
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_number.strtime
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    private Date strtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_number.endtime
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    private Date endtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_number.number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    private Integer number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_number.status
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_number.name
     *
     * @return the value of bs_number.name
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_number.name
     *
     * @param name the value for bs_number.name
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_number.phone
     *
     * @return the value of bs_number.phone
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_number.phone
     *
     * @param phone the value for bs_number.phone
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_number.strtime
     *
     * @return the value of bs_number.strtime
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public Date getStrtime() {
        return strtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_number.strtime
     *
     * @param strtime the value for bs_number.strtime
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public void setStrtime(Date strtime) {
        this.strtime = strtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_number.endtime
     *
     * @return the value of bs_number.endtime
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_number.endtime
     *
     * @param endtime the value for bs_number.endtime
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_number.number
     *
     * @return the value of bs_number.number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_number.number
     *
     * @param number the value for bs_number.number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_number.status
     *
     * @return the value of bs_number.status
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_number.status
     *
     * @param status the value for bs_number.status
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", strtime=").append(strtime);
        sb.append(", endtime=").append(endtime);
        sb.append(", number=").append(number);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
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
        BsNumber other = (BsNumber) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStrtime() == null ? other.getStrtime() == null : this.getStrtime().equals(other.getStrtime()))
            && (this.getEndtime() == null ? other.getEndtime() == null : this.getEndtime().equals(other.getEndtime()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStrtime() == null) ? 0 : getStrtime().hashCode());
        result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}
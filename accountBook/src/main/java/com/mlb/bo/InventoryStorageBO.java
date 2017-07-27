package com.mlb.bo;

public class InventoryStorageBO {
	// 年
	private int year;
	// 日期
	private String dateStr;
	// 已结算
	private Double hasSettled;
	// 未结算
	private Double notSettled;
	// 已付款
	private Double paidMoney;
	// 未付款
	private Double unpaidMoney;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public Double getHasSettled() {
		return hasSettled;
	}

	public void setHasSettled(Double hasSettled) {
		this.hasSettled = hasSettled;
	}

	public Double getNotSettled() {
		return notSettled;
	}

	public void setNotSettled(Double notSettled) {
		this.notSettled = notSettled;
	}

	public Double getPaidMoney() {
		return paidMoney;
	}

	public void setPaidMoney(Double paidMoney) {
		this.paidMoney = paidMoney;
	}

	public Double getUnpaidMoney() {
		return unpaidMoney;
	}

	public void setUnpaidMoney(Double unpaidMoney) {
		this.unpaidMoney = unpaidMoney;
	}

}

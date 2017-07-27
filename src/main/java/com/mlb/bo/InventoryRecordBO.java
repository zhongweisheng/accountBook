package com.mlb.bo;

public class InventoryRecordBO {

	// 日期
	private int year;
	// 日期
	private String dateStr;
	// 品种
	private int grainType;
	// 入库或出库
	private int recordType;
	// 入库毛重
	private Double grossInTotal;
	// 入库皮重
	private Double tareInTotal;
	// 入库净重
	private Double netInTotal;
	// 入库金额
	private Double moneyInTotal;
	// 平均成本(入库)
	private Double averageCost;
	// 平均价格(出库)
	private Double averagePrice;
	// 出库毛重
	private Double grossOutTotal;
	// 出库皮重
	private Double tareOutTotal;
	// 出库净重
	private Double netOutTotal;
	// 出库净额
	private Double moneyOutTotal;

	// 剩余公斤数
	private Double balance;
	// 库存金额
	private Double inventoryMoney;
	// 累计利润
	private Double totalProfit;
	// 每笔利润
	private Double profit;

	private Double price;

	private Double netWeightIn;

	private Double moneyIn;

	private Double netWeightOut;

	private Double moneyOut;

	// 未付款
	private Double weifuk;
	// 已付款
	private Double paidMoney;
	// 未付款
	
	private Double unpaidMoney;
	// 已结算
	private Double hasSettled;
	// 未结算
	private Double notSettled;

	// 扣重
	private Double deduction;

	public Double getDeduction() {
		return deduction;
	}

	public void setDeduction(Double deduction) {
		this.deduction = deduction;
	}

	public Double getNetWeightOut() {
		return netWeightOut;
	}

	public void setNetWeightOut(Double netWeightOut) {
		this.netWeightOut = netWeightOut;
	}

	public Double getMoneyOut() {
		return moneyOut;
	}

	public void setMoneyOut(Double moneyOut) {
		this.moneyOut = moneyOut;
	}

	public Double getNetWeightIn() {
		return netWeightIn;
	}

	public void setNetWeightIn(Double netWeightIn) {
		this.netWeightIn = netWeightIn;
	}

	public Double getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(Double moneyIn) {
		this.moneyIn = moneyIn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

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

	public int getGrainType() {
		return grainType;
	}

	public void setGrainType(int grainType) {
		this.grainType = grainType;
	}

	public int getRecordType() {
		return recordType;
	}

	public void setRecordType(int recordType) {
		this.recordType = recordType;
	}

	public Double getGrossInTotal() {
		return grossInTotal;
	}

	public void setGrossInTotal(Double grossInTotal) {
		this.grossInTotal = grossInTotal;
	}

	public Double getTareInTotal() {
		return tareInTotal;
	}

	public void setTareInTotal(Double tareInTotal) {
		this.tareInTotal = tareInTotal;
	}

	public Double getNetInTotal() {
		return netInTotal;
	}

	public void setNetInTotal(Double netInTotal) {
		this.netInTotal = netInTotal;
	}

	public Double getMoneyInTotal() {
		return moneyInTotal;
	}

	public void setMoneyInTotal(Double moneyInTotal) {
		this.moneyInTotal = moneyInTotal;
	}

	public Double getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(Double averageCost) {
		this.averageCost = averageCost;
	}

	public Double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}

	public Double getGrossOutTotal() {
		return grossOutTotal;
	}

	public void setGrossOutTotal(Double grossOutTotal) {
		this.grossOutTotal = grossOutTotal;
	}

	public Double getTareOutTotal() {
		return tareOutTotal;
	}

	public void setTareOutTotal(Double tareOutTotal) {
		this.tareOutTotal = tareOutTotal;
	}

	public Double getNetOutTotal() {
		return netOutTotal;
	}

	public void setNetOutTotal(Double netOutTotal) {
		this.netOutTotal = netOutTotal;
	}

	public Double getMoneyOutTotal() {
		return moneyOutTotal;
	}

	public void setMoneyOutTotal(Double moneyOutTotal) {
		this.moneyOutTotal = moneyOutTotal;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getInventoryMoney() {
		return inventoryMoney;
	}

	public void setInventoryMoney(Double inventoryMoney) {
		this.inventoryMoney = inventoryMoney;
	}

	public Double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(Double totalProfit) {
		this.totalProfit = totalProfit;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	public Double getWeifuk() {
		return weifuk;
	}

	public void setWeifuk(Double weifuk) {
		this.weifuk = weifuk;
	}

	public Double getUnpaidMoney() {
		return unpaidMoney;
	}

	public void setUnpaidMoney(Double unpaidMoney) {
		this.unpaidMoney = unpaidMoney;
	}

	public Double getPaidMoney() {
		return paidMoney;
	}

	public void setPaidMoney(Double paidMoney) {
		this.paidMoney = paidMoney;
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

}

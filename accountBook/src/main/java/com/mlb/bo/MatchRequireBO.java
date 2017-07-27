package com.mlb.bo;

public class MatchRequireBO {
	private int id = -1;

	private String createtime; // 创建时间
	private int graintype; // 粮食种类
	private Double price; // 金额
	private Double amount; // 数量
	private int location; // 位置码值
	private String qualitydesc; // 质量描述
	private double lng;
	private double lat;
	private String area;
	private int table;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getGraintype() {
		return graintype;
	}

	public void setGraintype(int graintype) {
		this.graintype = graintype;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getQualitydesc() {
		return qualitydesc;
	}

	public void setQualitydesc(String qualitydesc) {
		this.qualitydesc = qualitydesc;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

}

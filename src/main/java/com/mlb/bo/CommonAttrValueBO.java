package com.mlb.bo;

public class CommonAttrValueBO {
	private int id = -1;
	private String attrValue; // 属性值
	private int attrId; // 属性ID
	private int typeId; // 属性类型
	private int belongId; // 所属ID
	private int belongTable; // 所属表

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getAttrId() {
		return attrId;
	}

	public void setAttrId(int attrId) {
		this.attrId = attrId;
	}

	public int getBelongId() {
		return belongId;
	}

	public void setBelongId(int belongId) {
		this.belongId = belongId;
	}

	public int getBelongTable() {
		return belongTable;
	}

	public void setBelongTable(int belongTable) {
		this.belongTable = belongTable;
	}

}

package com.mlb.enums;

/**
 * 
 */
public enum GrainLevelEnum {

	全部(0, "全部"), 国标一等粮(1, "国标一等粮"), 国标二等粮(2, "国标二等粮"), 国标三等粮(3, "国标三等粮"),

	国标四等粮(4, "国标四等粮"), 国标五等粮(5, "国标五等粮"), 等外粮(6, "等外粮");

	private GrainLevelEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	private int code;
	private String name;

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.getCode() + "-" + this.getName();
	}

	public static String getName(int code) {
		String name = "";
		for (GrainLevelEnum c : GrainLevelEnum.values()) {
			if (c.getCode() == code) {
				name = c.getName();
				break;
			}
		}
		return name;
	}

}
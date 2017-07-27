package com.mlb.enums;

/**
 * 
 */
public enum GrainTypeEnum {

	小麦(1, "小麦"), 玉米(2, "玉米"), 水稻(3, "水稻");

	private GrainTypeEnum(int code, String name) {
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

	public static String getName(int code) {
		String name = "";
		for (GrainTypeEnum c : GrainTypeEnum.values()) {
			if (c.getCode() == code) {
				name = c.getName();
				break;
			}
		}
		return name;
	}

	public String toString() {
		return this.getCode() + "-" + this.getName();
	}

}
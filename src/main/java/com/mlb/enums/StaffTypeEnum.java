package com.mlb.enums;

/**
 * 
 */
public enum StaffTypeEnum {

	送粮人(1, "送粮人"), 买粮人(2, "买粮人"), 司机(3, "司机");

	private StaffTypeEnum(int code, String name) {
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
		for (StaffTypeEnum c : StaffTypeEnum.values()) {
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
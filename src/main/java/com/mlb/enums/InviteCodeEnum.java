package com.mlb.enums;

/**
 * 
 */
public enum InviteCodeEnum {

	可用(1, "可用"), 已用(2, "已用");

	private InviteCodeEnum(int code, String name) {
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
		for (InviteCodeEnum c : InviteCodeEnum.values()) {
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
package com.mlb.enums;

/**
 * 
 */
public enum RecordTypeEnum {

	入库(1, "入库"), 出库(2, "出库"), 代储(3, "代储");

	private RecordTypeEnum(int code, String name) {
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
		for (RecordTypeEnum c : RecordTypeEnum.values()) {
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
package fc.wpf.rest.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @date 2015-10-09
 */
public enum NotificationBindTypeEnum {

	用户(1, "用户"), 角色(2, "角色"), 菜单(3, "菜单"), 模组(4, "模组");

	/**
	 * @param type
	 *            type
	 * @param code
	 *            code
	 * @return BaseStatusEnum
	 */
	public static String getNameByCode(int code) {
		NotificationBindTypeEnum names = codeMap.get(code);
		if (names != null) {
			return names.getName();
		}
		return "未知状态";
	}

	public static int getCodeByCode(int code) {
		NotificationBindTypeEnum codes = codeMap.get(code);
		if (codes != null) {
			return codes.getCode();
		}
		return -1;
	}
	public static NotificationBindTypeEnum getNotificationBindTypeByCode(int code) {
		NotificationBindTypeEnum bindTypeEnum = codeMap.get(code);
		if (bindTypeEnum != null) {
			return bindTypeEnum;
		}
		return null;
	}
	public static int getCodeByName(String name) {
		NotificationBindTypeEnum codes = nameMap.get(name);
		if (codes != null) {
			return codes.getCode();
		}
		return -1;
	}

	private static Map<Integer, NotificationBindTypeEnum> codeMap;
	private static Map<String, NotificationBindTypeEnum> nameMap;

	private NotificationBindTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;

	}

	static {
		codeMap = new HashMap<Integer, NotificationBindTypeEnum>();
		nameMap = new HashMap<String, NotificationBindTypeEnum>();
		for (NotificationBindTypeEnum type : NotificationBindTypeEnum.values()) {
			codeMap.put(type.getCode(), type);
			nameMap.put(type.getName(), type);
		}
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

}
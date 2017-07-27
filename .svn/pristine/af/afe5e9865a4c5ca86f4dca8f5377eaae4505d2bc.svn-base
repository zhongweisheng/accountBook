package fc.wpf.rest.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例枚举类 参考编写自己的枚举类
 * @author reid
 *
 */
public enum TaskStatusEnum {
	
	Completed(1, "完成"),
	VerifyCodeWrong(2, "验证码错误"),
	Failed(0, "失败");

	public static String getNameByValue(int value) {
		TaskStatusEnum status = valueMap.get(value);
		if (status != null) {
			return status.getName();
		}
		return "未知状态";
	}

	public static Integer getValueByName(String name) {
		TaskStatusEnum status = nameMap.get(name);
		if (status != null) {
			return status.getValue();
		}
		return null;
	}

	private static Map<Integer, TaskStatusEnum> valueMap;

	private static Map<String, TaskStatusEnum> nameMap;
	static {
		valueMap = new HashMap<Integer, TaskStatusEnum>();
		nameMap = new HashMap<String, TaskStatusEnum>();
		for (TaskStatusEnum status : TaskStatusEnum.values()) {
			valueMap.put(status.getValue(), status);
			nameMap.put(status.getName(), status);
		}
	}

	private int value;
	private String name;

	private TaskStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.getValue() + "-" + this.getName();
	}
}

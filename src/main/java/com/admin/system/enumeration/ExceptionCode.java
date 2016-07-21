package com.admin.system.enumeration;

public enum ExceptionCode {
	SUCCESS(0, "成功"),
	/** 认证失败 **/
	AUTHENTICATION_FAILURE(1, "认证失败");
	private final Integer code;
	private final String message;

	private ExceptionCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 获取code值
	 * 
	 * @return
	 */
	public Integer getCode() {
		return this.code;
	}

	/**
	 * 获取描述
	 * 
	 * @return
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * 获取对应code枚举类型
	 * 
	 * @param code
	 * @return
	 */
	public static ExceptionCode fromCode(Integer code) {
		for (ExceptionCode entity : ExceptionCode.values()) {
			if (entity.getCode() == code) {
				return entity;
			}
		}
		return null;
	}
}

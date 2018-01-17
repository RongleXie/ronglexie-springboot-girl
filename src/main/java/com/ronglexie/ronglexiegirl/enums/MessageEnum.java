package com.ronglexie.ronglexiegirl.enums;

/**
 * 消息枚举
 *
 * @author wxt.xqr
 * @version 2018-1-17
 */
public enum MessageEnum {

	UNKNOW_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功"),
	NONAGE(110,"未成年人员"),
	ADULT(200,"已成年人员");

	private Integer code;

	private String msg;

	MessageEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

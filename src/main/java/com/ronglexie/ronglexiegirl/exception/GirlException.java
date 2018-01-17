package com.ronglexie.ronglexiegirl.exception;

import com.ronglexie.ronglexiegirl.enums.MessageEnum;

/**
 * 自定义异常类
 *
 * @author ronglexie
 * @version 2018-1-17
 */
public class GirlException extends Exception {

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public GirlException(MessageEnum messageEnum) {
		super(messageEnum.getMsg());
		this.code = messageEnum.getCode();
	}
}

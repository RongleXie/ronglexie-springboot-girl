package com.ronglexie.ronglexiegirl.handle;

import com.ronglexie.ronglexiegirl.enums.MessageEnum;
import com.ronglexie.ronglexiegirl.exception.GirlException;
import com.ronglexie.ronglexiegirl.utils.Messageutils;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * @author ronglexie
 * @version 2018-1-17
 */
@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object handle(Exception e){
		if (e instanceof GirlException) {
			GirlException girlException = (GirlException) e;
			return Messageutils.error(girlException.getCode(), girlException.getMessage());
		}else if (e instanceof UnauthorizedException){
			return Messageutils.error(MessageEnum.UNAUTHORIZED.getCode(),MessageEnum.UNAUTHORIZED.getMsg());
		}
		else {
			logger.error("【系统异常】{}", e);
			return Messageutils.error(MessageEnum.UNKNOW_ERROR.getCode(), "未知错误");
		}
	}
}

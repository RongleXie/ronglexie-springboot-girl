package com.ronglexie.ronglexiegirl.utils;

import com.ronglexie.ronglexiegirl.entity.Message;

/**
 * 消息工具类
 *
 * @author ronglexie
 * @version 2018-1-17
 */
public class Messageutils {

    /**
     * 返回成功消息
     *
     * @param msg
     * @param object
     * @return java.lang.Object
     * @author wxt.xqr
     * @version 2018-1-17
     */
    public static Object successed(String msg,Object object){
        Message message = new Message();
        message.setCode(200);
        message.setMsg(msg);
        message.setResult(object);
        return message;
    }

    /**
     * 返回成功消息
     *
     * @return java.lang.Object
     * @author wxt.xqr
     * @version 2018-1-17
     */
    public static Object successed(){
        return successed("成功","");
    }

    /**
     * 返回失败消息
     *
     * @param msg
     * @return java.lang.Object
     * @author wxt.xqr
     * @version 2018-1-17
     */
    public static Object error(String msg){
        Message message = new Message();
        message.setCode(-1);
        message.setMsg(msg);
        message.setResult(null);
        return message;
    }
}

package com.ronglexie.ronglexiegirl.entity;

/**
 * 统一消息类
 *
 * @author ronglexie
 * @version 2018-1-17
 */
public class Message<T> {

    /** 编码 */
    private Integer code;

    /** 消息 */
    private String msg;

    /** 结果集 */
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}

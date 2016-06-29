package com.airkisser.mybatis.utils.exception;

/**
 * Created by AIR on 2016/6/29.
 */
public class ToDoException extends RuntimeException {

    public ToDoException() {
        super("未完成的方法");
    }

    public ToDoException(String message) {
        super(message);
    }
}

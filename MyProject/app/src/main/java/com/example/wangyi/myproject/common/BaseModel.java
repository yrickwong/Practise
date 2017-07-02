package com.example.wangyi.myproject.common;

/**
 * Created by wangyi on 2017/6/29.
 */

public abstract class BaseModel<T> {
    T data;

    protected abstract void sendRequest(Object... params);
}

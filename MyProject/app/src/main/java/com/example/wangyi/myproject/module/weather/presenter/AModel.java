package com.example.wangyi.myproject.module.weather.presenter;

import com.example.wangyi.myproject.common.BaseModel;

/**
 * Created by wangyi on 2017/6/29.
 */

public class AModel extends BaseModel<A> {

    @Override
    protected void sendRequest(Object... params) {
        String url = (String) params[0];
    }
}

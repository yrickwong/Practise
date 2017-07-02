package com.example.wangyi.myproject.module.weather.presenter;

import com.example.wangyi.myproject.common.BasePresenter;

/**
 * Created by wangyi on 2017/6/29.
 */

public class APresenter extends BasePresenter<AView,AModel>{
    public APresenter(){
        bindModel(new AModel());
    }
}

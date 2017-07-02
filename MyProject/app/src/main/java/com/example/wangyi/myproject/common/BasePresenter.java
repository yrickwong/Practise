package com.example.wangyi.myproject.common;

/**
 * Created by wangyi on 2017/6/29.
 */

public abstract class BasePresenter<V extends IBaseView, M extends BaseModel> {
    V mView;

    M mModel;


    void sendRequest(Object... params) {
        mModel.sendRequest(params);
    }

    protected void bindModel(M model) {
        mModel = model;
    }

    void bindView(V view) {
        mView = view;
    }

    void onDestroy() {
        mView = null;
        mModel = null;
    }
}

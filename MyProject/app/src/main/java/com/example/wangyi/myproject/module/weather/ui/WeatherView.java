package com.example.wangyi.myproject.module.weather.ui;

import com.example.wangyi.myproject.module.weather.entity.Weather;

/**
 * Created by wangyi on 2017/6/29.
 */

public interface WeatherView {
    void showLoading();

    void hideLoading();

    void showError();

    void onSuccess(Weather weather);
}

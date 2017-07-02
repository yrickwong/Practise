package com.example.wangyi.myproject.module.weather.model;

import com.example.wangyi.myproject.module.weather.entity.Weather;

/**
 * Created by wangyi on 2017/6/29.
 */

public interface WeatherModel {
    void loadWeather(String info);
    Weather getData();
}

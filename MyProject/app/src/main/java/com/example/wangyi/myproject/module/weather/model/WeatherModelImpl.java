package com.example.wangyi.myproject.module.weather.model;

import android.os.SystemClock;

import com.example.wangyi.myproject.module.weather.entity.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyi on 2017/6/29.
 */

public class WeatherModelImpl implements WeatherModel {
    Weather weather;
    List<INotifyListener> notifyListeners;

    public WeatherModelImpl(INotifyListener listener) {
        addNotifyListener(listener);
    }

    private synchronized void addNotifyListener(INotifyListener listener) {
        if (notifyListeners == null) {
            notifyListeners = new ArrayList<>();
        }
        notifyListeners.add(listener);
    }

    @Override
    public void loadWeather(String info) {
        new Thread() {
            @Override
            public void run() {
                try {
                    weather = generateWeatherInfo();
                    SystemClock.sleep(1000 * 3);
                    notifySuccess();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void notifySuccess() {
        for (INotifyListener listener : notifyListeners) {
            listener.onSuccess();
        }
    }

    @Override
    public Weather getData() {
        return weather;
    }

    private Weather generateWeatherInfo() {
        //// FIXME: 2017/6/29 you can get data from internet
        return new Weather();
    }

}

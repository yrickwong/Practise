package com.example.wangyi.myproject.module.weather.presenter;

import com.example.wangyi.myproject.module.weather.model.INotifyListener;
import com.example.wangyi.myproject.module.weather.model.WeatherModel;
import com.example.wangyi.myproject.module.weather.model.WeatherModelImpl;
import com.example.wangyi.myproject.module.weather.ui.WeatherView;

/**
 * Created by wangyi on 2017/6/29.
 */

public class WeatherPresenterImpl implements WeatherPresenter, INotifyListener {

    private WeatherView weatherView;
    private WeatherModel weatherModel;

    public WeatherPresenterImpl(WeatherView view) {
        weatherView = view;
        //bindModel
        weatherModel = new WeatherModelImpl(this);
    }

    @Override
    public void getWeather(String info) {
        weatherView.showLoading();
        weatherModel.loadWeather(info);
    }

    @Override
    public void onDestroy() {
        weatherModel = null;
        weatherView = null;
    }

    @Override
    public void onSuccess() {
        weatherView.hideLoading();
        weatherView.onSuccess(weatherModel.getData());
    }

    @Override
    public void onFailed() {
        weatherView.hideLoading();
        weatherView.showError();
    }
}

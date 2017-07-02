package com.example.wangyi.myproject;

import android.os.Bundle;

/**
 * Created by wangyi on 2017/7/2.
 */

public class MainFragment extends BaseFragment {
    public static final String TAG = "MainFragment";

    public static MainFragment newInstance(){
        MainFragment mainFragment=new MainFragment();
        Bundle bundle=new Bundle();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected String getFragmentPageTag() {
        return TAG;
    }
}

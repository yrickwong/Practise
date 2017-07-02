package com.example.wangyi.myproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.tabLayout)
    TabLayout mTablayout;//tablayout属于viewpager的装饰view

    private static final String[] tabs = new String[]{"关注", "推荐", "附近"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected String getPageTag() {
        return TAG;
    }

    private void initView() {
        for (String tab : tabs) {
            TextView textView = (TextView) View.inflate(this, R.layout.tv_scaletextview, null);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            textView.setText(tab);
            textView.setTextSize(22);//sp
            mTablayout.addTab(mTablayout.newTab().setCustomView(textView));
        }
        //没有下标
        mTablayout.setSelectedTabIndicatorHeight(0);
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                customView.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).start();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                customView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //设置默认位置
        mTablayout.getTabAt(2).select();

        addFragment(MAIN_TAB);
    }

    private static final int MAIN_TAB = 1;

    private void addFragment(int tab) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (tab) {
            case MAIN_TAB:
                fragmentTransaction.add(R.id.content,MainFragment.newInstance(), MainFragment.TAG);
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
    }

}

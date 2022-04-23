package com.example.activity.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends FragmentActivity{
    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        getPreIntent();
        initView();
        initData();
        initListener();
    }

    abstract int getLayoutId();

    void getPreIntent(){}

    void initView(){}

    void initData(){}

    void initListener(){}
}


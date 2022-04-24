package com.example.activity.activity;

import android.view.View;
import android.widget.Chronometer;
import android.content.Intent;
import com.example.activity.R;
import com.lzy.okgo.OkGo;

import butterknife.OnClick;
import butterknife.BindView;
import com.example.activity.constants.config;

public class AnswerActivity extends BaseActivity implements Chronometer.OnChronometerTickListener {
    private String kind;
    private String num;
    private String type;
    Chronometer chronometer;
    private int minute = 0;
    private int second = 0;

    @Override
    int getLayoutId()
    {
        return R.layout.activity_answer;
    }

    @Override
    void getPreIntent() {
//        获取传递来的变量
        kind = getIntent().getStringExtra("kind");
        num = getIntent().getStringExtra("num");
    }

    @Override
    void initView() {
        initNet();
        setChronometer();
    }

    private void setChronometer() {
        chronometer.setText(nowtime());
        chronometer.start();
        chronometer.setOnChronometerTickListener(this);
    }

    /**
     * 计时器规则
     *
     * @param chronometer
     */
    @Override
    public void onChronometerTick(Chronometer chronometer) {
        second++;
        if (second == 59) {
            minute++;
            second = 00;
        }
    }

    private String nowtime()
    {
        if (second < 10) {
            return (minute + ":0" + second);
        } else {
            return (minute + ":" + second);
        }
    }

    private void initNet()
    {

    }

}
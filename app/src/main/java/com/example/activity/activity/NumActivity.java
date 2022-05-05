package com.example.activity.activity;


import android.content.Intent;
import android.view.View;

import com.example.activity.MyApplication;
import com.example.activity.R;

import butterknife.OnClick;

public class NumActivity extends BaseActivity {
    @Override
    int getLayoutId()
    {
        return R.layout.activity_num;
    }

    @OnClick({R.id.num_ret, R.id.singleNum, R.id.matchNum})
    public void onViewClicked(View view)
    {
        switch(view.getId())
        {
            case R.id.num_ret:
                this.finish();
                break;
            case R.id.singleNum:
                Intent intent2 = new Intent(NumActivity.this,FieldChooseActivity.class);
                ((MyApplication)getApplication()).setPlaytype("single");
                startActivity(intent2);
                break;
            case R.id.matchNum:
                Intent intent3 = new Intent(NumActivity.this,FieldChooseActivity.class);
                ((MyApplication)getApplication()).setPlaytype("match");
                startActivity(intent3);
                break;
        }
    }

}
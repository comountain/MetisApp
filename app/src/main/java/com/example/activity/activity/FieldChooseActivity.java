package com.example.activity.activity;

import android.content.Intent;
import android.view.View;

import com.example.activity.R;
import com.example.activity.activity.BaseActivity;

import butterknife.OnClick;

public class FieldChooseActivity extends BaseActivity {
    @Override
    int getLayoutId()
    {
        return R.layout.activity_field_choose;
    }

    @OnClick({R.id.field_1,R.id.field_2,R.id.field_3,R.id.field_4,R.id.field_4,R.id.field_5,R.id.field_6,R.id.field_7})
    public void onViewClicked(View view)
    {
        Intent intent = new Intent(FieldChooseActivity.this, FieldChooseActivity.class);
        startActivity(intent);
        switch(view.getId())
        {
            case R.id.field_1:
            case R.id.field_2:
            case R.id.field_3:
            case R.id.field_4:
            case R.id.field_5:
            case R.id.field_6:
            case R.id.field_7:
        }
    }
}
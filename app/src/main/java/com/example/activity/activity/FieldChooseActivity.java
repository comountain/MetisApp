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

    @OnClick({R.id.field_1,R.id.field_2,R.id.field_3,R.id.field_4,R.id.field_5,R.id.field_6,R.id.field_7,R.id.ret})
    public void onViewClicked(View view)
    {
        /*Intent intent = new Intent(FieldChooseActivity.this, FieldChooseActivity.class);
        startActivity(intent);*/
        switch(view.getId())
        {
            case R.id.field_1:
                Intent intent1 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent1.putExtra("field","Literature");
                startActivity(intent1);
                break;
            case R.id.field_2:
                Intent intent2 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent2.putExtra("field","History");
                startActivity(intent2);
                break;
            case R.id.field_3:
                Intent intent3 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent3.putExtra("field","Films");
                startActivity(intent3);
                break;
            case R.id.field_4:
                Intent intent4 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent4.putExtra("field","Art");
                startActivity(intent4);
                break;
            case R.id.field_5:
                Intent intent5 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent5.putExtra("field","Geography");
                startActivity(intent5);
                break;
            case R.id.field_6:
                Intent intent6 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent6.putExtra("field","Science");
                startActivity(intent6);
                break;
            case R.id.field_7:
                Intent intent7 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent7.putExtra("field","All");
                startActivity(intent7);
                break;
            case R.id.ret:
                this.finish();
                break;
        }
    }
}
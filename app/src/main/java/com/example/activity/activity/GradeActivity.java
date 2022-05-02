package com.example.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.activity.R;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import butterknife.OnClick;

public class GradeActivity extends BaseActivity {
    String grade;

    @Override
    int getLayoutId()
    {
        return R.layout.activity_grade;
    }

    @Override
    void getPreIntent() {grade = getIntent().getExtras().get("grade").toString().trim();}

    @Override
    void initView()
    {
        TextView gradeToShow = (TextView) findViewById(R.id.grade_grade);
        gradeToShow.setText(grade+"分");
    }

    @OnClick({R.id.grade_return})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.grade_return:
                Intent intent1 = new Intent(GradeActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
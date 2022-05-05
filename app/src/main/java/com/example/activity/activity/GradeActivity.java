package com.example.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.activity.MyApplication;
import com.example.activity.R;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;

public class GradeActivity extends BaseActivity {
    String grade;
    String playernum;
    boolean ret = false;

    @Override
    int getLayoutId()
    {
        return R.layout.activity_grade;
    }

    @Override
    void getPreIntent()
    {
        playernum = ((MyApplication)getApplication()).getPlaytype();
        grade = getIntent().getExtras().get("grade").toString().trim();
    }

    @Override
    void initView()
    {
        if(playernum.equals("match"))
        {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    while (!ret) {
                        HashMap<String, String> result = ((MyApplication) getApplication()).getGameresult();
                        String show = (grade + "分\n");
                        for (Map.Entry<String, String> entry : result.entrySet())
                            show += entry.getKey() + "的分数为： " + entry.getValue() + "分\n";
                        TextView gradeToShow = (TextView) findViewById(R.id.grade_grade);
                        gradeToShow.setText(show);
                    }
                }
            };
            thread.start();
        }
        else
        {
            TextView gradeToShow = (TextView) findViewById(R.id.grade_grade);
            gradeToShow.setText(grade + "分\n");
        }
    }

    @OnClick({R.id.grade_return})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.grade_return:
                ret = true;
                ((MyApplication)getApplication()).resetGameresult();
                Intent intent1 = new Intent(GradeActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
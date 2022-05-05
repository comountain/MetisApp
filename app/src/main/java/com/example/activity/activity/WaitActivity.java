package com.example.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.activity.MyApplication;
import com.example.activity.R;
import com.example.activity.message.MatchMessage;

import android.content.Intent;
import android.os.Bundle;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

import java.util.Date;


public class WaitActivity extends BaseActivity {
    private String player;
    private String field;
    private StringBuilder sb = new StringBuilder();

    @Override
    int getLayoutId() {
        return R.layout.activity_wait;
    }

    @Override
    void getPreIntent() {
        player = ((MyApplication)getApplication()).getPlaytype();
        field = getIntent().getExtras().get("field").toString().trim();
    }

    @Override
    public void initView() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String username = ((MyApplication)getApplication()).getUsername();
                ((MyApplication) getApplication()).sendMessage(new MatchMessage(username, "2"));
                while (!((MyApplication) getApplication()).ifMatched()) {
                    continue;
                }
                ((MyApplication) getApplication()).resetIfMatched();
                Intent intent1 = new Intent(WaitActivity.this, AnswerActivity.class);
                intent1.putExtra("field", field);
                startActivity(intent1);
            }
        };
        thread.start();
    }
}
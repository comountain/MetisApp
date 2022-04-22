package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button creR = (Button)findViewById(R.id.createRoom);
        creR.setOnClickListener(new CreRListener());
    }

    class CreRListener implements View.OnClickListener{
        @Override
        public void onClick(View v){

        }
    }
}
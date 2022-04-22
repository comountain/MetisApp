package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class RoomChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_choose);
        Button startGame = (Button)findViewById(R.id.startRoom);
        Button addPlayer1 = (Button)findViewById(R.id.AddPlayer1);
        Button addPlayer2 = (Button)findViewById(R.id.AddPlayer2);
        Button addPlayer3 = (Button)findViewById(R.id.AddPlayer3);
        Button addPlayer4 = (Button)findViewById(R.id.AddPlayer4);
    }
}
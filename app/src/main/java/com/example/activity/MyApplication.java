package com.example.activity;

import android.app.Application;

import com.example.activity.message.CompeteMessage;
import com.example.activity.message.MatchMessage;
import com.example.activity.service.CientService;
import com.example.activity.message.GamerMessage;

import java.util.HashMap;

public class MyApplication extends Application {
    public String username = "aa";
    public String playtype;
    CientService cientService = new CientService();
    @Override
    public void onCreate()

    {
        super.onCreate();
        cientService.start();
        cientService.setUser(username);
    }

    public void setPlaytype(String ty)
    {
        playtype = ty;
    }

    public String getPlaytype()
    {
        return playtype;
    }

    public String getUsername()
    {
        return username;
    }

    public void sendMessage(GamerMessage msg)
    {
        cientService.sendMessage(msg);
    }

    public void sendMessage(MatchMessage msg)
    {
        cientService.sendMessage(msg);
    }

    public void sendMessage(CompeteMessage msg)
    {
        cientService.sendMessage(msg);
    }


    public boolean ifMatched()
    {
        return cientService.isIfMatched();
    }

    public HashMap<String, String> getGameresult()
    {
        return cientService.getGameresult();
    }

    public void resetIfMatched()
    {
        cientService.resetIfMatched();
    }

    public void resetGameresult()
    {
        cientService.resetGameresult();
    }

}

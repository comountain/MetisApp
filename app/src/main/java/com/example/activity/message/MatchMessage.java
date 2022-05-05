package com.example.activity.message;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class MatchMessage {
    private String type = "2";
    private String name;
    private String num;

    public MatchMessage(String username, String num)
    {
        this.name = username;
        this.num = num;
    }

    public String MessageString()
    {
        return type+"_"+name+"_"+num;
    }
}

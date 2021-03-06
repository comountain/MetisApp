package com.example.activity.constants;

public class config {
    //是否开启调试模式
    public static final boolean DEBUG = true;
    //    Log 打印的 tag
    public static final String LogTag = "metis";

    //    主机 host
    public static final String HOST = "http://192.168.1.106:8081/";
    //    登录网址
    public static final String URL_LOGIN = HOST + "LogLet";
    //    注册网址
    public static final String URL_SIGNUP = HOST + "RegLet";
    //    获取问题网址
    public static final String URL_GET_QUESTION = HOST + "getQuests";

    //    获取试卷题目网址
    public static final String URL_GET_TEST_QUESTION = HOST + "GetTestList";
    public static final String URL_UP_USER_GRADE = HOST + "UpUserGrade";
}

package com.shenl.androidTest;

import org.xutils.http.RequestParams;
import org.xutils.http.app.ParamsBuilder;

import java.util.HashMap;

public class HttpUrl {
    public static final String BASE = "http://10.19.92.71:88/";
    public static final String IPaddress = BASE + "auth_oa";

    public static String imei = "";
    public static String username = "";
    public static String accessToken = "";
    public static HashMap<String, Object> map;

    public static RequestParams getParams(){
        RequestParams params = new RequestParams();
        params.addHeader("","");
        return params;
    }
}

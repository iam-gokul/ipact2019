package com.playstore.ieee.ipact2019.remote;

public class ApiUtils {
    public static final String BASE_URL = "https://ipactconference.com/api/";

    public static Api getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(Api.class);
    }
}

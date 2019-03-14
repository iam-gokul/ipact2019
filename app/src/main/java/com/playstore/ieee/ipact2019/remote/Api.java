package com.playstore.ieee.ipact2019.remote;

import com.playstore.ieee.ipact2019.model.Admin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    @FormUrlEncoded
    @POST("adminlogin.php")
    Call<Admin> validate(
            @Field ("email") String email,
            @Field ("password") String password
    );
}

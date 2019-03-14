package com.playstore.ieee.ipact2019;

import android.accounts.Account;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.playstore.ieee.ipact2019.model.Admin;
import com.playstore.ieee.ipact2019.remote.Api;
import com.playstore.ieee.ipact2019.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences mSharedPreferences;
    private EditText mEditTextemail;
    private EditText mEditTextpass;
    private Button butt;
    String email, password;

    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
        mEditTextemail = findViewById (R.id.loginEmail);
        mEditTextpass = findViewById (R.id.loginPassword);
        butt = findViewById (R.id.loginSign);
        api = ApiUtils.getUserService ();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        butt.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                email = mEditTextemail.getText ().toString ();
                password = mEditTextpass.getText ().toString ();
                Log.d ("ipactt", "button clicked");
                login (email, password);
            }
        });


    }

    public void login(String email, String password) {
        Log.d ("ipactt", email);
        Call<Admin> call = api.validate (email, password);
       call.enqueue (new Callback<Admin> () {
           @Override
           public void onResponse(Call<Admin> call, Response<Admin> response) {
               Admin admin=response.body ();
               try{


               if(admin.getLogin_status ().equals ("1")){
                   SharedPreferences.Editor editor = mSharedPreferences.edit();
                   editor.putBoolean("status", false);
                   if(admin.getType ().equals ("0"))editor.putBoolean ("Admin",false);
                   else if(admin.getType ().equals ("1"))editor.putBoolean ("Admin",true);
                   editor.apply();
                   Log.d("ipactt","hi"+admin.getLogin_status ()+"  "+admin.getName ());
                   Intent intent = new Intent (LoginActivity.this,Home.class);
                   startActivity(intent);
                   Toast.makeText (LoginActivity.this, "Hi "+admin.getName ()+" You are an Admin", Toast.LENGTH_SHORT).show ();
               }}catch (NullPointerException e){
                   Log.d("ipactt","Null Pointer");
               }

               Log.d("ipactt",admin.getLogin_status ()+" "+admin.getName ());
           }

           @Override
           public void onFailure(Call<Admin> call, Throwable t) {
               Log.d("ipactt",t.getMessage ());

           }
       });
    }
}




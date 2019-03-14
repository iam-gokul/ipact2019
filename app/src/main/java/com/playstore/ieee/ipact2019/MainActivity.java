package com.playstore.ieee.ipact2019;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        SharedPreferences mSharedPreferences;

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean welcomeScreenShown = mSharedPreferences.getBoolean("status", true);

        if(!welcomeScreenShown) {
            Intent intent = new Intent (MainActivity.this,Home.class);
            startActivity (intent);
        }
        mButton= findViewById (R.id.button);
        mButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,LoginActivity.class);
                startActivity (intent);
            }
        });
    }
}

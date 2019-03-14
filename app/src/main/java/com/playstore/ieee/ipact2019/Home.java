package com.playstore.ieee.ipact2019;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    private FrameLayout mFrameLayout;
    SharedPreferences mSharedPreferences;

    private ScanFragment mScanFragment;
    private AnnouncementFragment mAnnouncementFragment;
    private NotificationFragment mNotificationFragment;
    private SearchFragment mSearchFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mFrameLayout=(FrameLayout) findViewById (R.id.main_frame);
        mBottomNavigationView=(BottomNavigationView) findViewById (R.id.main_nav);

        mScanFragment = new ScanFragment ();
        mAnnouncementFragment = new AnnouncementFragment ();
        mNotificationFragment = new NotificationFragment ();
        mSearchFragment = new SearchFragment ();

        mBottomNavigationView.setOnNavigationItemSelectedListener (new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId ()){

                    case R.id.nav_scan :
                        setFragment(mScanFragment);
                        return true;
                    case R.id.nav_announce :
                        setFragment(mAnnouncementFragment);
                        return true;
                    case R.id.nav_notify :
                        setFragment(mNotificationFragment);
                        return true;
                    case R.id.nav_search :
                        setSearchFragment(mSearchFragment);
                        return true;
                    default:
                        return false;

                }
            }
        });

    }
    private void setFragment(Fragment homefragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager ().beginTransaction ();
        fragmentTransaction.replace (R.id.main_frame,homefragment);
        fragmentTransaction.commit ();
    }
    private  void setSearchFragment(Fragment searchFragment){
        Boolean showSearch = mSharedPreferences.getBoolean("Admin", false);
        if(showSearch)setFragment (searchFragment);
        else Toast.makeText (this, "You are not authorized to use this feature", Toast.LENGTH_SHORT).show ();
    }
}

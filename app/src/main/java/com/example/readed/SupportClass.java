package com.example.readed;

import android.content.pm.ActivityInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SupportClass {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void prepareScreen(AppCompatActivity activity){
        activity.getWindow().setNavigationBarColor(activity.getResources().getColor(R.color.sizzlingRed));
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void removeSupportBar(AppCompatActivity activity){
        activity.getSupportActionBar().hide();
    }

    public static SupportClass newInstance(){
        return new SupportClass();
    }
}

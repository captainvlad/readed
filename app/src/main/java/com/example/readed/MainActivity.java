package com.example.readed;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean isShown = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportClass.newInstance().prepareScreen(this);
        SupportClass.newInstance().removeSupportBar(this);
    }

    public void logInListener(View v){
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    public void signUpListener(View v){
        Intent intent = new Intent(getBaseContext(), SignUpActivity.class);
        startActivity(intent);
    }

    public void onSettingsListener(View v){

        Fragment myFragment = getSupportFragmentManager().findFragmentByTag("detailFragment");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (myFragment == null){
            myFragment = new SettingsFragment();
            ft.setCustomAnimations(R.anim.fragment_close_enter, R.anim.fragment_close_exit);
            ft.add(R.id.settingsFragment, myFragment, "detailFragment");
        }

        if (isShown){
            ft.hide(myFragment);
            findViewById(R.id.settingsFragment).setVisibility(View.GONE);
            isShown = false;
        } else{
            findViewById(R.id.settingsFragment).setVisibility(View.VISIBLE);
            ft.show(myFragment);
            isShown = true;
        }

        ft.commit();

    }

    public void onInfoListener(View v){
        Fragment myFragment = getSupportFragmentManager().findFragmentByTag("infoFragment");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (myFragment == null){
            myFragment = new InfoFragment();
            ft.setCustomAnimations(R.anim.fragment_close_enter, R.anim.fragment_close_exit);
            ft.add(R.id.settingsFragment, myFragment, "infoFragment");
        }

        if (isShown){
            ft.hide(myFragment);
            findViewById(R.id.settingsFragment).setVisibility(View.GONE);
            isShown = false;
        } else{
            findViewById(R.id.settingsFragment).setVisibility(View.VISIBLE);
            ft.show(myFragment);
            isShown = true;
        }

        ft.commit();
    }
}
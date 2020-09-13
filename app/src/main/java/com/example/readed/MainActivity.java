package com.example.readed;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

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
        Log.d("AAA", "DIP signUpButton Called");
    }

}
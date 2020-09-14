package com.example.readed;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SupportClass.newInstance().removeSupportBar(this);
        SupportClass.newInstance().prepareScreen(this);
    }

    private void checkInputValues(){
        EditText name = findViewById(R.id.textView2);
        EditText password = findViewById(R.id.textView3);
        EditText passwordConfiramtion = findViewById(R.id.textView4);

        String nameValue = name.getText().toString();
        String passwordValue = password.getText().toString();
        String passwordConfirmationValue = passwordConfiramtion.getText().toString();

        if (!nameValue.isEmpty() && !passwordValue.isEmpty() && passwordValue.equals(passwordConfirmationValue) ){
//            Start new Activity! or Save into Shared preferences!
            return;
        } if (!nameValue.isEmpty() && !passwordValue.isEmpty() && !passwordConfirmationValue.equals(passwordValue) ){
            SupportClass.newInstance().emptyValueCaution(this, R.string.passwords_not_equal);
            return;
        }

        SupportClass.newInstance().emptyValueCaution(this);
    }

    public void continueListener(View v){
        checkInputValues();

//        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.nameSurname), MODE_PRIVATE);
//        String name = sharedPref.getString(getString(R.string.nameKey), null);
//        String password = sharedPref.getString(getString(R.string.passwordKey), null);
    }
}
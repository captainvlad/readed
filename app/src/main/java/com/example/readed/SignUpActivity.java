package com.example.readed;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private void saveValuesIntoSharedPreferences(String name, String password){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.nameSurname), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.nameKey), name);
        editor.putString(getString(R.string.passwordKey), password);
        editor.commit();
    }

    private void checkInputValues(){
        EditText name = findViewById(R.id.textView2);
        EditText password = findViewById(R.id.textView3);
        EditText passwordConfiramtion = findViewById(R.id.textView4);

        String nameValue = name.getText().toString();
        String passwordValue = password.getText().toString();
        String passwordConfirmationValue = passwordConfiramtion.getText().toString();

        if (!nameValue.isEmpty() && !passwordValue.isEmpty() && passwordValue.equals(passwordConfirmationValue) ){
            saveValuesIntoSharedPreferences(nameValue, passwordValue);
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            return;
        } if (!nameValue.isEmpty() && !passwordValue.isEmpty() && !passwordConfirmationValue.equals(passwordValue) ){
            SupportClass.newInstance().emptyValueCaution(this, R.string.passwords_not_equal);
            return;
        }

        SupportClass.newInstance().emptyValueCaution(this);
    }

    public void continueListener(View v){
        checkInputValues();
    }
}
package com.example.readed;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        SupportClass.newInstance().prepareScreen(this);
        SupportClass.newInstance().removeSupportBar(this);

        if ( rememberedUserExists() ){
            askUserToSkip();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void emptyValueCaution(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);

        builder.setMessage(R.string.emptyInputMessage)
                .setTitle(R.string.emptyInputTitle)
        .setPositiveButton(R.string.confirmation_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();
        dialog.getWindow().setLayout(900, 500);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean checkUserInput(EditText name, EditText password){
        String nameValue = name.getText().toString();
        String passwordValue = password.getText().toString();

        if (nameValue.isEmpty() || passwordValue.isEmpty()){
            emptyValueCaution();
            return false;
        }

        return true;
    }

    private void saveValuesIntoSharedPreferences(String name, String password){
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.nameKey), name);
        editor.putString(getString(R.string.passwordKey), password);
        editor.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onContinueListener(View v){
        EditText nameInput = findViewById(R.id.nameInput);
        EditText passwordInput = findViewById(R.id.passwordInput);

        if ( checkUserInput(nameInput, passwordInput) ){
            saveValuesIntoSharedPreferences(nameInput.getText().toString(), passwordInput.getText().toString());
        }
    }

    private boolean rememberedUserExists(){
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);

        String name = sharedPref.getString(getString(R.string.nameKey), null);
        String password = sharedPref.getString(getString(R.string.passwordKey), null);

        boolean res = !name.isEmpty() && !password.isEmpty();
        return res;
    }

    private void askUserToSkip(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle2);

        builder.setTitle(getString(R.string.user_exists))
                .setPositiveButton(getString((R.string.skip)), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(getString((R.string.unskip)), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.show();
        dialog.getWindow().setLayout(900, 500);
    }
}
package com.example.readed;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SupportClass {
    private int messageForDialog = R.string.emptyInputMessage;


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

    public void emptyValueCaution(Activity activity){
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogStyle);

        builder.setMessage(messageForDialog)
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

    public void emptyValueCaution(Activity activity, int message){
        messageForDialog = message;
        emptyValueCaution(activity);
    }
}

package com.dummies.invest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

public class Alerts {

    private final Context mContex;
    private String Title,Message,Positive,Negative;

    public  Alerts(Context context, String Title, String Message,String Positive, String Negative){
        this.mContex = context;
        this.Title = Title;
        this.Message = Message;
        this.Positive = Positive;
        this.Negative = Negative;

    }

    public void showAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContex);

        //Setting dialog Title
        alertDialog.setTitle(Title);

        //Setting dialog msg
        alertDialog.setMessage(Message);

        //On pressing settings button
        alertDialog.setPositiveButton(Positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
            }
        });

//        // on pressing cancel button
//        alertDialog.setNegativeButton(Negative, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//
//            }
//        });

        //show alert dialog
        alertDialog.show();
    }
}

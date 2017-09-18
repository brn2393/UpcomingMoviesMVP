package com.buddhabhushan.b.mobisysassignment.domain;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.buddhabhushan.b.mobisysassignment.R;
import com.buddhabhushan.b.mobisysassignment.app.MoviesApp;

/**
 * Created by Buddhabhushan on 17-Sep-17. 16-Sep-17.
 */

public abstract class AppPreferences {

    public static void showAlert(View view, String message, int type) {
        switch (type) {
            case Constants.ALERT_TYPE_TOAST:
                Toast.makeText(MoviesApp.getContext(), message, Toast.LENGTH_SHORT).show();
                break;
            case Constants.ALERT_TYPE_DIALOG:
                showAlertDialog(message, view);
                break;
            case Constants.ALERT_TYPE_SNACK:
                Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    public static void showAlertDialog(String message, View v) {
        new AlertDialog.Builder(v.getContext())
                .setTitle(R.string.app_name)
                .setMessage(message)
                .setCancelable(true)
                .setIcon(android.R.mipmap.sym_def_app_icon)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager conMgr = (ConnectivityManager)
                MoviesApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        return netInfo != null && netInfo.isAvailable() && netInfo.isConnectedOrConnecting();
    }
}

package com.exercise.android.careergps.UIHandler;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.exercise.android.careergps.R;

/**
 * Created by Benix on 3/11/2018.
 */

public class AlertBox {
    public AlertBox() {
    }
    public AlertDialog setAlertDialog(final Context mContext, Boolean haveNegative, DialogInterface.OnClickListener positiveOnclick, DialogInterface.OnClickListener negativeOnclick, String pbtntxt, String nbtntxt, String msg, String title) {
        AlertDialog dialog = new AlertDialog.Builder(mContext, R.style.AppTheme)
                .setMessage(msg)
                .setTitle(title)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton(pbtntxt, positiveOnclick).create();
        if (haveNegative)
            dialog.setButton(Dialog.BUTTON_NEGATIVE, nbtntxt, negativeOnclick);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
            }
        });
        return dialog;
    }
}

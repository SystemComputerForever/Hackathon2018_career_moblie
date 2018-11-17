package com.exercise.android.careergps.UIHandler;

import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Benix on 3/11/2018.
 */

public class OnClickMethod {

    public DialogInterface.OnClickListener errorOnClick(final Context mContext) {
        DialogInterface.OnClickListener dialogOnclick = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                return;
            }
        };
        return dialogOnclick;
    }
}

package com.example.myapplication.help;

import android.content.Context;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackbarHelper {

    public static void config(Context context, Snackbar snack) {
        addMargins(snack);
        setRoundBordersBg(context, snack);
        ViewCompat.setElevation(snack.getView(), 6f);
    }

    private static void addMargins(Snackbar snack) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) snack.getView().getLayoutParams();
        params.setMargins(12, 12, 12, 12);
        snack.getView().setLayoutParams(params);
    }

    private static void setRoundBordersBg(Context context, Snackbar snackbar) {
        snackbar.getView().setBackground(context.getResources().getDrawable(R.color.purple_700));
    }



    //双重检测
    private static volatile SnackbarHelper snackbarHelper2;


    public static SnackbarHelper getInstance2() {
        if (snackbarHelper2 == null) {
            synchronized (SnackbarHelper.class) {
                if (snackbarHelper2 == null) {
                    snackbarHelper2 = new SnackbarHelper();
                }

            }
        }
        return snackbarHelper2;
    }



    //静态内部类
    public static SnackbarHelper getInstance() {
        return Singleinstant.snackbarHelper;
    }

    private static class Singleinstant {
        private static final SnackbarHelper snackbarHelper = new SnackbarHelper();

    }





}

package com.chinazyjr.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by niudeyang on 2017/12/14.
 */

public class Utils {
    public static void showToast(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT);
    }
}

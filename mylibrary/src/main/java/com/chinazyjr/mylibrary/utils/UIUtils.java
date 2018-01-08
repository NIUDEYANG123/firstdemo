package com.chinazyjr.mylibrary.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;



/**
 * Created by xuxinkai on 2015/12/28.
 */
public class UIUtils {

    private static AlertDialog dialog;


    //尺寸转化
    public static int dp2px(int dp, Context context) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                context.getResources().getDisplayMetrics());
    }

    public static int sp2px(int sp, Context context) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                sp,
                context.getResources().getDisplayMetrics());
    }

    /**
     * dip转换px
     */
    public static int dip2px(Context context,int dip) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */
    public static int px2dip(Context context,int px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }


    public static View inflate(Context context,int resId) {
        return LayoutInflater.from(context).inflate(resId, null);
    }

    /**
     * 获取资源
     */
    public static Resources getResources(Context context) {
        return context.getResources();
    }

    /**
     * 获取文字
     */
    public static String getString(Context context,int resId) {
        return context.getString(resId);
    }

    /**
     * 获取文字数组
     */
    public static String[] getStringArray(Context context,int resId) {
        return context.getResources().getStringArray(resId);
    }

    /**
     * 获取dimen
     */
    public static int getDimens(Context context,int resId) {
        return context.getResources().getDimensionPixelSize(resId);
    }

    /**
     * 获取drawable
     */
    public static Drawable getDrawable(Context context,int resId) {
        return context.getResources().getDrawable(resId);
    }


    /**
     * 获取颜色
     */
    public static int getColor(Context context,int resId) {
        return context.getResources().getColor(resId);
    }

    public static void showToastCommon(final Context context, final String str) {
        Toast toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 获取颜色选择器
     */
    public static ColorStateList getColorStateList(Context context,int resId) {
        return context.getResources().getColorStateList(resId);
    }


    /**
     * DisplayMetrics metric = new DisplayMetrics();
     * activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
     * int width = metric.widthPixels;  // 屏幕宽度（像素）
     * int height = metric.heightPixels;  // 屏幕高度（像素）
     * float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5/2.0）
     * int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240/320）
     * int screenWidth = (int) (width / density);//屏幕宽度(dp)
     * int screenHeight = (int) (height / density);//屏幕高度(dp)
     * AppContext.getAppContext().setDpHeight(screenWidth);
     * AppContext.getAppContext().setDpWidth(screenHeight)
     */
    //获取屏幕的宽度
    public static int getWidthPixes(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widthPixels = dm.widthPixels;
        return widthPixels;
    }

    /**
     * 手势解锁获取屏幕的分辨率
     *
     * @param context
     * @return
     */
    public static int[] getScreenDispaly(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        int[] result = {width / 2, height / 2};
        return result;
    }
}

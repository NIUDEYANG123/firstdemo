package com.chinazyjr.githubapplication.utils

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Build
import android.speech.RecognizerIntent
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.util.TypedValue
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.chinazyjr.githubapplication.R
import com.chinazyjr.githubapplication.base.App
import com.chinazyjr.githubapplication.base.App.Companion.context
import com.chinazyjr.mylibrary.base.ActivityCollector
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.annotations.NotNull

/**
 * Created by liuzipeng on 2017/2/15.
 */
//扩展属性
val View.ctx: Context
    get() = context

fun Any.log(msg: String) {
    Log.d(this.javaClass.simpleName, msg)
}

/**
 * 隐藏错误图片
 */
fun Fragment.hideErrorImg(@NotNull viewGroup: ViewGroup) {
    viewGroup.visibility = View.GONE
}

/**
 * 隐藏错误图片
 */
fun Activity.hideErrorImg(@NotNull viewGroup: ViewGroup) {
    viewGroup.visibility = View.GONE
}


inline fun Context.hasNavigationBar(block: () -> Unit) {
    //通过判断设备是否有返回键、菜单键(不是虚拟键,是手机屏幕外的按键)来确定是否有navigation bar
    val hasMenuKey = ViewConfiguration.get(this)
            .hasPermanentMenuKey()
    val hasBackKey = KeyCharacterMap
            .deviceHasKey(KeyEvent.KEYCODE_BACK)

    if (!hasMenuKey && !hasBackKey) {
        block()
    }
}

inline fun Any.supportL(block: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        block()
    }
}


fun Int.sp2px(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), App.instance.resources.displayMetrics)
fun Int.dp2px(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), App.instance.resources.displayMetrics)
fun Float.dp2px(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, App.instance.resources.displayMetrics)
inline fun <reified T : Activity> Activity.newIntent(action: String) {
    val intent = Intent(this, T::class.java)
    intent.action = action
    startActivity(intent)
}

fun <T> Observable<T>.applySchedulers(): Observable<T> {
    return subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

/**
 * 当前网络是否可用
 */
inline fun Any.netAvailable(block: (a: Boolean) -> Unit) {
    if (Utils.isNetworkAvailable(App.instance)) block(true) else block(false)
}

/**
 * 获取字符串
 */
fun Context.obtainString(resId: Int): String = this.resources.getString(resId)

/**
 * 获取颜色
 */
fun Context.obtainColor(resId: Int): Int = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    this.resources.getColor(resId, null)
} else {
    this.resources.getColor(resId)
}

var exitTime: Long = 0

fun clickBack(keyCode: Int, event: KeyEvent?): Boolean {
    if (keyCode == KeyEvent.KEYCODE_BACK && event?.action == KeyEvent.ACTION_DOWN) {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(context, "再按一次退出程序", Toast.LENGTH_SHORT)
            exitTime = System.currentTimeMillis()
        } else {

            ActivityCollector.finishAll()
            System.exit(0)
        }
        return true
    }
    return false
}

fun toast(str: String) {
    Toast.makeText(context, str, Toast.LENGTH_SHORT)
}

fun Activity.openActivity(intent: Intent) {
    startActivity(intent)
    overridePendingTransition(R.anim.in_anim, R.anim.out_anim)
}

fun Activity.closeActivity() {
    finish()
    overridePendingTransition(R.anim.in_anim_left, R.anim.out_anim_right)
}
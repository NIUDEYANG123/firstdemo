package com.chinazyjr.githubapplication.custom

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.chinazyjr.githubapplication.R

class VerticalDoubleTextView(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : LinearLayout(context, attributeSet, defStyleAttr) {
    private var mTv2: TextView? = null//下部textview
    private var mTv1: TextView? = null//上部textview
    private var instance: VerticalDoubleTextView? = null
    private var textColorTop: Int = 0//上部颜色
    private var textSizeTop: Int = 0//上部大小
    private var textColorBottom: Int = 0//下部颜色
    private var textSizeBottom: Int = 0//下部大小
    private var textTop: String? = null//上部文本
    private var textBottom: String? = null//下部文本
    private var textGravity = 1//textview的文本是否剧中
    private var ivLeft: Drawable? = null
    private var ivRight: Drawable? = null
    private var drablepadding: Int = 0
    private var textmargin: Int = 0

    private val llroot: LinearLayout? = null
    private var tstyle: Int = 0

    constructor(context: Context, ttributeSet: AttributeSet) : this(context, ttributeSet, 0) {
        val a = context.obtainStyledAttributes(ttributeSet, R.styleable.VeticalDoubleTextView)
        for (i in 0 until a.indexCount) {
            var attr = a.getIndex(i)
            when (attr) {
                R.styleable.VeticalDoubleTextView_textColorTop -> textColorTop = a.getColor(attr, Color.parseColor("#ffffff"))
                R.styleable.VeticalDoubleTextView_textSizeTop -> textSizeTop = a.getDimensionPixelSize(attr, TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_SP, 12f, resources.displayMetrics).toInt())
                R.styleable.VeticalDoubleTextView_textColorBottom -> textColorBottom = a.getColor(attr, Color.parseColor("#ffffff"))
                R.styleable.VeticalDoubleTextView_textSizeBottom -> textSizeBottom = a.getDimensionPixelSize(attr, TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_SP, 16f, resources.displayMetrics).toInt())
                R.styleable.VeticalDoubleTextView_textTop -> textTop = a.getString(attr)
                R.styleable.VeticalDoubleTextView_textBottom -> textBottom = a.getString(attr)
                R.styleable.VeticalDoubleTextView_textGravity -> textGravity = a.getInt(attr, 1)
                R.styleable.VeticalDoubleTextView_tstyle -> tstyle = a.getInt(attr, -1)
                R.styleable.VeticalDoubleTextView_textmargin -> textmargin = a.getDimensionPixelSize(attr, TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 6f, resources.displayMetrics).toInt())
                R.styleable.VeticalDoubleTextView_ivleft -> ivLeft = a.getDrawable(attr)
                R.styleable.VeticalDoubleTextView_ivright -> ivRight = a.getDrawable(attr)
                R.styleable.VeticalDoubleTextView_textdrablepadding -> drablepadding = a.getDimensionPixelSize(attr, TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt())
                else -> {
                }
            }
        }
        a.recycle()

        mTv1 = TextView(context)
        mTv2 = TextView(context)
        mTv1!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizeTop.toFloat())
        mTv2!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizeBottom.toFloat())
        mTv2!!.setTextColor(textColorBottom)
        mTv1!!.setTextColor(textColorTop)
        mTv1!!.compoundDrawablePadding = drablepadding
        mTv2!!.compoundDrawablePadding = drablepadding
        ivLeft?.setBounds(0, 0, ivLeft!!.minimumWidth, ivLeft!!.minimumHeight)
        ivRight?.setBounds(0, 0, ivRight!!.minimumWidth, ivRight!!.minimumHeight)
        mTv1!!.text = textTop
        mTv2!!.text = textBottom

        if (tstyle == 0) {
            mTv1!!.typeface = Typeface.defaultFromStyle(Typeface.BOLD)//加粗
        } else if (tstyle == 1) {
            mTv2!!.typeface = Typeface.defaultFromStyle(Typeface.BOLD)//加粗
        }

        this.orientation = VERTICAL
        val l1 = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        l1.bottomMargin = textmargin
        addView(mTv1, l1)
        addView(mTv2, LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
    }

    public fun setTextTop(textTop: String) {
        mTv1!!.text = textTop
    }

    public fun setTextBottom(textb: String) {
        mTv2!!.text = textb
    }
}
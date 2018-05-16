package com.chinazyjr.githubapplication.custom.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import com.chinazyjr.githubapplication.R
import kotlinx.android.synthetic.main.dialog_open.*

class OpenDialog(step: Int, context: Context, vararg clicks: (() -> Unit)) : Dialog(context, R.style.dialogWrong) {

    init {
        window.attributes.gravity = Gravity.CENTER and Gravity.CENTER_HORIZONTAL
        setContentView(R.layout.dialog_open)
        when (step) {
            1 -> {
                tv_open.text = "立即开启"
            }
            2 -> {
                tv_open.text = "立即激活"
            }
            3 -> {
                tv_open.text = "开启主动投标"
            }
        }
        tv_open.setOnClickListener { clicks[0]() }
        iv_button.setOnClickListener {
            clicks[1]()
            dismiss()
        }


    }
}
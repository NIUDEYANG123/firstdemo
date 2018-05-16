package com.chinazyjr.githubapplication.inteface

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * 输入两位小数,.开头自动转0.,0开头不能继续输入
 */
class NumEditWatcaher(var edittext: EditText) : TextWatcher{
    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        var s=p0?.toString()
        if(s!!.contains(".")){
            if(s.length-1-s.indexOf(".")>2){
               s=s.substring(0,s.indexOf(".")+3)
                edittext.setText(s)
                edittext.setSelection(s.length)
            }
        }

        if(s.trim().substring(0) == "."){
            edittext.setText("0$s")
            edittext.setSelection(2)
        }

        if(s.startsWith("0")&&s.trim().length>1){
            if(s.substring(1,2)!="."){
                edittext.setText(s.substring(0,1))
                edittext.setSelection(1)
            }
        }
    }

}
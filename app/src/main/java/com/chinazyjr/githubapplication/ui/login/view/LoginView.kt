package com.chinazyjr.haollyv2.ui.login.view

import com.chinazyjr.haollyv2.base.IBaseView
import com.chinazyjr.haollyv2.entity.login.LoginBean

/**
 * Created by niudeyang on 2017/12/8.
 */
interface LoginView :IBaseView{
    fun login(it: LoginBean)
}
package com.chinazyjr.haollyv2.ui.login.view

import com.chinazyjr.haollyv2.base.IBaseView
import com.chinazyjr.haollyv2.entity.login.LoginBean
import com.chinazyjr.haollyv2.entity.login.TokenBean

/**
 * Created by niudeyang on 2017/12/8.
 */
interface RegisterView :IBaseView{
 fun showIamgeCode(tokenBean: TokenBean)

 fun countDown(b: Boolean)

  fun showSucess()
}
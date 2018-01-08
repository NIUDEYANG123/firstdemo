package com.chinazyjr.githubapplication.base

import android.app.Application
import com.chinazyjr.mylibrary.utils.LogUtils
import com.chinazyjr.mylibrary.utils.WYUtils
import com.taobao.sophix.PatchStatus
import com.taobao.sophix.SophixManager
import com.taobao.sophix.listener.PatchLoadStatusListener

/**
 * Created by niudeyang on 2018/1/8.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initRexiufu()
    }

    private fun initRexiufu() {
        // initialize最好放在attachBaseContext最前面，初始化直接在Application类里面，切勿封装到其他类
        SophixManager.getInstance().setContext(this)
                .setAppVersion(WYUtils.getAppVersionName(applicationContext))
                .setSecretMetaData("24757354-1", "01a27e571c4fbfd6ed8d1ef46aa67535", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCxD+MB62pSRpH6pN6dUhgVPLBIB7SIqzlX5o+3R1oZY/BLLTtiXnAG4ZcXpua0AZmeZuc0aYhActw7T2rirE0baY5FiET/T+smEUi3Uvmuh2rcFJJ0qPLGP/JkpL82Fj9t0QEU19aXFJh7FT22q0iHQmLInvDwkTJ1qQnOcL0LZJsR6GXO/cW+DMVPrcHLBybVo/vl+XUSnGGCWnP/CwTJRuEDeQ/vZv4ZvvkQeRc1Z7LQlH9M6lksQnmASLL7CN8DkTHnmiJ+rq/dhsryfgmPQvuBcgk8ZCIyZyaTBzl65pOHH0CEeut6cfnfNx/pLynYnRmyTtQoUe4ADKxnV1zlAgMBAAECggEASLE3B6C449JpODfb1UbQ8FccIFZZfgqd3kKgGiTHDsmC67pEORyAbbLMLz+sU5aclPW2UkRJVfxSAl+WiD0o4uoxKMbLXO5YoiZSbkE4lLiv3G7tuctq8I1sXHluryvvGozGHuKGDTy9ZTrRPV+QxUcx+x+V144k4z1k80ZBtp0F6faBhNMAcklpixi4BE47JX8oTlYN5E5WMyycfYasmJ3+8nYlE868fbailMRzLXcg6l05ARnBr4VAqeZKhel8u0IVzwAlcz+MYou/lEfSI7P6JaW4tdggm64zri3N3Os97rWVl0cvg0ORQO8cdqVjR0vpYYja9WU80UpMDJc7uQKBgQDlOW/ufdtlZPQToNNOSG3y7g3dXM7Szo4uo31Za4R/ll2ZPyZ43kEgnzyUilPq7XMxlTfIPz+QxpDLF5N4rv+Jds7vupi6cw300gZvBqv1hjDd7+lLJ/VnPGLtGUeyKsNEDlA3IfLITLD26mBr4hjOJwweqLcPiRt56/b/gF6GnwKBgQDFvp/5xMA2KsL89S7MD/bQCrr/8RAHYjbveUctA6dOdWTIuTfbw00ZvWLlgntWeDqzMDqQSa2SlunpLeYInBx9j6mbA0s8SLO+i5+y8QV0ARiul/x+aYXxEBkMbgf0DuBRyz91WTM4tywyu+ZZ2b38uzjK9LcuO062sdhjeqVB+wKBgQDB2lFO4CErHrVL5DbPfXF+gNQ44MQIg6a6yoi3lrX3MLL3ZvCiR1PMwt34wQM3KpjA1fDW6KZZSZQqLUYKSfTRzCg1lRiUlbi30uad/oZunY22I66oYKKpK+h9m2OGyaNZasFr3snzmugN6SiiFBPmRB97zjMCcHFMKsI4UdefAQKBgCO2dbXqLryZpHWC4lzAVVblWTh4FOkAd+NwB8a9bi3hTb5ilQ//iaEobv/8PMI1HITYJPuCEvLyhnQyceUELLEQjRUN1zyf9LZpCQKMPOvids6xbEx4SlRrD9sK1CzjsueSyXcsEPAhRL406Tk49fL67Rrab2rOEz0ziV0N/WKZAoGBAM5wRsOZ9LhByphwx/y2hPVdoyCz3znjwYFa7lMeoTccA0VwJjiHy8yxFhhp/fCvBzvx5BJ0urGVqiaYrzy4iRS/7sv2Q8zNcA4wqalnF9v8JIrSU7AHjTeM1LrkRYalShYxHX+D6ucBht9uVNPwpPBwJnvrtvwQoXJPGx7Hvntq")
                .setAesKey(null)
                .setEnableDebug(true)
                .setPatchLoadStatusStub { mode, code, info, handlePatchVersion ->
                    // 补丁加载回调通知
                    if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                        // 表明补丁加载成功
                        LogUtils.e("ndy", StringBuilder().append(mode).append(code).append(info).toString())
                    } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                        // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
                        // 建议: 用户可以监听进入后台事件, 然后调用killProcessSafely自杀，以此加快应用补丁，详见1.3.2.3
                    } else {
                        // 其它错误信息, 查看PatchStatus类说明
                    }
                }.initialize()
        // queryAndLoadNewPatch不可放在attachBaseContext 中，否则无网络权限，建议放在后面任意时刻，如onCreate中
        SophixManager.getInstance().queryAndLoadNewPatch()
    }
}
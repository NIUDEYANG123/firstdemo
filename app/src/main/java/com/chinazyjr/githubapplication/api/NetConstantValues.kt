package com.chinazyjr.githubapplication.api

import com.chinazyjr.githubapplication.BuildConfig

/**
 * Created by niudeyang on 2017/12/8.
 */
class NetConstantValues {
    companion object {
        const val HOST_URL = BuildConfig.INTERFACE
        const val CONTRACT_URL = BuildConfig.INTERFACE_CONTART
        /**
         * 公共
         */
        const val image_url = HOST_URL + "common/getValidateImage"//图形验证码
        const val SMSCODE = "common/getSmsCode"//短信验证码
        const val TOKEN = "common/getToken"//获取token
        const val REFRESH_TOKEN = "user/token/refresh"//刷新token
        const val USERSTATUS = "common/getUserStatus"//根据手机号获取用户状态
        const val GET_BANKS = "common/getBanksQuota"//银行卡列表
        const val IS_UPDATE = "version/isUpdate"//获取版本更新
        /**
         * 第一板块
         */
        const val USER_LOGIN = "user/login"//登陆
        const val USER_LOGINOUT = "user/logout"//退出登录
        const val USER_REGISTER = "user/register"//注册
        const val USER_RESETPWD = "user/forgetPassWord"//重置密码
        const val USER_CAHNGE_PASS = "user/changePassword"//修改密码
        const val USER_IS_REGIESTER = "user/isRegister"//用户是否注册

        /**
         * 汇付(账户)
         */
        const val SENDSMSCODE = "account/sendSmsCode"//发送汇付短信验证码
        const val OPENACCOUNT = "account/openAccount"//开户
        const val BOSACCTACTIVATE = "user/bosAcctActivate"//激活
        const val CONFIRM_RECHARGE = "recharge/confirmRecharge"//提交充值
        const val RECHARGE_RESULT = "recharge/queryRechargeResult"//充值结果查询
        const val QUERY_RECHARGE = "recharge/queryBeforeRecharge"//充值前查询银行卡查询
        const val ISWITHDRAWSUCCESS = "usertrade/isWithdrawSuccess"//取现是否成功
        const val CASH = "usertrade/userCash"//取现
        const val QUIK_BIND = "account/quickBinding"//换绑卡
        const val CASHFEE = "usertrade/userCashFee"//计算取现手续费
        const val AUTO_TENDER_PLAN = "userManage/autoTenderPlan"//自动投标计划
        const val QUERY_TENDER_PLAN = "userManage/queryTenderPlan"//自动投标计划状态查询


        /**
         * 产品列表
         */
        const val PRODUCT_LIST = "product/planList" //产品列表()
        const val PRODUCT_DETAIL = "product/productDetail"//标的详情
        const val INVEST_RECORD = "product/investRecord"//投资记录
        const val REPAY_PLAN = "product/getReturn"//散标还款计划
        /*散标还款计划new*/
        const val SAN_REPAY_PLAN = "billInvestDetail/queryByBorrowNo"
        const val SYANDARD_PLANLIST = "product/standardAndPlanList"//散标、预约标列表
        const val HOME_BORROW_LIST = "homePage/homePageBorrowList"//首页产品列表
        const val HOME_BANNER = "homePage/homePageBannerArticle"//首页banner和公告
        const val PLANBORROWFORAPP = "product/fingPlanBorrowForApp"//卓头预约标列表
        const val BORROWPLANLIST = "product/borrowPlanList"//赢计划散标列表
        const val DQYMORE = "product/queryBorrowDqyList"//短期赢更多

        const val NOTICE = "notice/selectNotice"//公告


        /**
         * 购买
        */
        const val BORROW_INVEST = "invest/borrowInvest"//购买
        const val EXPECTED_REVENUE = "invest/getExpectedRevenue"//计算收益
        const val EXPECTEDREVENUE_NEW = "invest/getHistoryExpectedRevenue"//计算基础收益和平台奖励收益
        const val QUERY_TRANS_STA = "invest/queryTransStat" //交易状态查询
        const val BILL_ADVANCE = "invest/queryBillInvestAdvance"//回款预告


        /**
          * 第二板块
          */
        const val BID = "do.jhtml?router=bidsService"
        /*借款人信息 H5写*/
        const val BID_QUERYBIDTABURL = "$BID.queryBidTab"
       /*散标购标记录*/
        const val BID_QUERYINVESTLISTURL = "$BID.queryInvestList"
      /*平台交易信息*/
        const val INDEXCOUNTBID = "do.jhtml?router=indexCountService.get"



        /**
        * 第四板块
         */
        const val USERACCOUNT = "account/userAccountInfo"//用户账户信息
        const val INVESTCOUPON = "coupon/investCoupon"//投资卡券
        const val WITHDRAWCOUPON = "coupon/withDrawCoupon"//提现券
        const val ALLCOUPON = "coupon/accountCoupon"//账户卡券纵览


        /**
        * 账户中心
         */

        const val HOME_PAGE = "useraccount/homePage"//账户中心首页
        const val TRANSACTION_RECORD = "useraccount/transactionRecord"//交易记录
        const val TRANSACTION_RECORD_DETAILS = "useraccount/tradeRecordDetails"//交易详情
        const val PRODUCT_MANAGE = "useraccount/productManage" //产品列表
        const val QUERYLISTBYSTATUSTYPE = "my/queryListByStatusType"//列表页各个状态相应查询
        const val CONTINUE_OPEN_CLOSE = "useraccount/continueOpenClose"//续投关闭或者开启
        const val PRODUCT_MANAGE_DETAIL = "my/queryListDetailsByStatusType" //账户中心产品详情
        const val QUERYCARDINFO = "userQuery/queryCardInfo"//查询银行卡信息
        const val QUERYSIGNSTATUS = "signing/querySigningStatus"//查询签约状态
        const val SIGNCONTRACT = "signing/signingContract"//签约
        const val LOCALCONTRACT = "signing/previewSigningContract"//本地合同
        const val BAOQUAN_CONTRACT = "signing/getPreviewContractLink"//保全合同
        const val CASH_HELD = "debt/cash/held"//当前持有债权
        const val CASH_HELD_NEW = "my/queryMatchDebtByOrderNo"//投标记录
        const val MESSAGE_LIST = "account/"//消息列表;
        const val MODIFICATION_MESSAGE = "account/deleteMessage"//修改消息
        const val ASSET_REPAY_PLAN = "borrowReserve/getBorrowReserveHuman"//个人中心预约标回款计划
        const val RISK_SOCRE = "user/getUserAnswer"//风险测评分数

        /**
        const  * h5
        const  */

        const val disclosure = CONTRACT_URL + "Agreement/bidplancontract.html"//详情1的借款协议
        const val watch_old2 = "https://hlwm.chinazyjr.net/?loginStatus"//检测到返回新版app
        const val watch_old = "https://hlwm.chinazyjr.com/?loginStatus"
        const val risk_testgl = CONTRACT_URL + "about/evaluating.html"//风险测评
        const val back_old = "http://weixin.haolyy.com/Index/juidLogin?juid="//返回旧版
        const val url_borrow = CONTRACT_URL + "Agreement/loanService.html"//出借咨询服务协议
        const val about2_url = CONTRACT_URL + "about/2.html"//散标的出借协议
        const val invite = CONTRACT_URL + "activity/inviteIndex.html?"
        //String invite="http://192.168.20.82:8000/html/activity/inviteindex.html";
        //String invite="http://192.168.21.170:8000/html/activity/inviteindex.html";
    }

}

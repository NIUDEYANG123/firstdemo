package com.chinazyjr.githubapplication.entity.product

import com.chinazyjr.githubapplication.entity.BaseBean

/**
 * Created by niudeyang on 2017/8/16.
 */

class HomeListBean : BaseBean(){


    /**
     * code : success
     * msg : 成功
     * model : {"noviciateBorrow":[{"appendRate":0,"profitPlan":4,"proportion":50,"periodUnit":2,"productName":"中赢宝","borrowName":"新手标","investMinAmount":100,"annualizedRate":10,"contractAmount":10000,"periodLength":52,"borrowType":2,"investMaxAmount":10000,"borrowNo":"ZZT-1000000310834253","status":7}],"recommendBorrow":[],"planBorrow":[{"appendRate":0.05,"profitPlan":4,"proportion":61,"periodUnit":2,"productName":"月满赢","borrowName":"测试理财师","investMinAmount":100,"annualizedRate":6,"contractAmount":100000,"periodLength":5,"borrowType":2,"investMaxAmount":100000,"borrowNo":"ZZT-1000000528107073","status":4}]}
     */
    var model: ModelBean? = null

    class ModelBean {
        var noviciateBorrow: List<NoviciateBorrowBean>? = null
        var recommendBorrow: List<*>? = null
        lateinit var planBorrow: List<PlanBorrowBean>

        class NoviciateBorrowBean {
            /**
             * appendRate : 0.0
             * profitPlan : 4
             * proportion : 50.0
             * periodUnit : 2
             * productName : 中赢宝
             * borrowName : 新手标
             * investMinAmount : 100.0
             * annualizedRate : 10.0
             * contractAmount : 10000.0
             * periodLength : 52
             * borrowType : 2
             * investMaxAmount : 10000.0
             * borrowNo : ZZT-1000000310834253
             * status : 7
             */

            var appendRate: Double = 0.toDouble()
            var profitPlan: Int = 0
            var proportion: Double = 0.toDouble()
            var periodUnit: Int = 0
            var productName: String? = null
            var borrowName: String? = null
            var investMinAmount: Double = 0.toDouble()
            var annualizedRate: Double = 0.toDouble()
            var contractAmount: Double = 0.toDouble()
            var periodLength: Int = 0
            var borrowType: Int = 0
            var investMaxAmount: Double = 0.toDouble()
            var borrowNo: String? = null
            var status: Int = 0
        }

        class PlanBorrowBean {
            /**
             * appendRate : 0.05
             * profitPlan : 4
             * proportion : 61.0
             * periodUnit : 2
             * productName : 月满赢
             * borrowName : 测试理财师
             * investMinAmount : 100.0
             * annualizedRate : 6.0
             * contractAmount : 100000.0
             * periodLength : 5
             * borrowType : 2
             * investMaxAmount : 100000.0
             * borrowNo : ZZT-1000000528107073
             * status : 4
             */

            var appendRate: Double = 0.toDouble()
            var profitPlan: Int = 0
            var proportion: Double = 0.toDouble()
            var periodUnit: Int = 0
            var productName: String? = null
            var borrowName: String? = null
            var investMinAmount: Double = 0.toDouble()
            var annualizedRate: Double = 0.toDouble()
            var contractAmount: Double = 0.toDouble()
            var periodLength: Int = 0
            var borrowType: Int = 0
            var investMaxAmount: Double = 0.toDouble()
            var borrowNo: String? = null
            var status: Int = 0
        }
    }
}

package com.chinazyjr.githubapplication.entity.product


data class BorrowPlanListBean(
    val code: String,
    val msg: String,
    val model: Model
) {
    data class Model(
        val newBidList: List<NewBid>,
        val noviciateBorrow: List<NoviciateBorrow>,
        val dqyBorrowList: List<Any>,
        val list: List<X>
    ) {
        data class NewBid(
            val appendRate: Double,
            val profitPlan: Int,
            val proportion: Double,
            val periodUnit: Int,
            val productName: String,
            val borrowName: String,
            val investMinAmount: Double,
            val annualizedRate: Double,
            val contractAmount: Double,
            val periodLength: Int,
            val borrowType: Int,
            val investMaxAmount: Double,
            val borrowNo: String,
            val amountWait: Double,
            val status: Int
        )
        data class NoviciateBorrow(
            val appendRate: Double,
            val profitPlan: Int,
            val proportion: Double,
            val periodUnit: Int,
            val productName: String,
            val borrowName: String,
            val investMinAmount: Double,
            val annualizedRate: Double,
            val contractAmount: Double,
            val periodLength: Int,
            val borrowType: Int,
            val investMaxAmount: Double,
            val borrowNo: String,
            val amountWait: Double,
            val status: Int
        )
        data class X(
            val id: Int,
            val borrowNo: String,
            val borrowName: String,
            val borrowType: Int,
            val borrowActiveType: Int,
            val annualizedRate: Double,
            val appendRate: Double,
            val periodUnit: String,
            val periodLength: Int,
            val contractAmount: Double,
            val status: Int,
            val remark: Any,
            val productNo: String,
            val fromBorrowContractNo: Any,
            val accountId: Any,
            val accountOrgId: Any,
            val thirdPlatformId: Any,
            val thirdUserId: Any,
            val firstCategoryId: Any,
            val secondCategoryId: Any,
            val createTime: String,
            val updateTime: String,
            val platform: Any,
            val version: Any,
            val amountWait: Double,
            val countPeople: Any,
            val startDate: String,
            val investminamount: Double,
            val scatteredBorrowKind: Any,
            val activeMainCode: Any,
            val activeChildCode: Any
        )
    }
}
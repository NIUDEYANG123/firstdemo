package com.chinazyjr.githubapplication.entity.product

import com.chinazyjr.githubapplication.entity.BaseBean
import java.io.Serializable

/**
 * @author wyman
 * @date 2018/3/3
 * description : 公告
 */

class Notice : Serializable,BaseBean() {
    /**
     * code : success
     * msg : 成功
     * model : {"total":1,"list":[{"id":38,"title":"好利标题","noticeContext":"好利描述","createTime":"2017-11-10 20:10:04","read":false}]}
     */
    var model: ModelBean? = null

    class ModelBean : Serializable {
        /**
         * total : 1
         * list : [{"id":38,"title":"好利标题","noticeContext":"好利描述","createTime":"2017-11-10 20:10:04","read":false}]
         */

        var total: Int = 0
        var list: List<ListBean>? = null

        class ListBean : Serializable {

            /**
             * id : 38
             * title : 好利标题
             * noticeContext : 好利描述
             * createTime : 2017-11-10 20:10:04
             * read : false
             */

            var id: Int = 0
            var title: String? = null
            var noticeContext: String? = null
            var createTime: String? = null
            var isRead: Boolean = false
            override fun toString(): String {
                return "ListBean{" +
                        "id=" + id +
                        ", title='" + title + '\''.toString() +
                        ", noticeContext='" + noticeContext + '\''.toString() +
                        ", createTime='" + createTime + '\''.toString() +
                        ", read=" + isRead +
                        '}'.toString()
            }
        }
    }
}

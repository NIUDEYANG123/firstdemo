package com.chinazyjr.githubapplication.entity.product

import com.chinazyjr.githubapplication.entity.BaseBean

/**
 * Created by liliang on 2017/9/15.
 */

class HomeBannerBean : BaseBean() {
    /**
     * code : success
     * msg : 成功
     * model : {"homestatic":{"income":2265958.64,"amount":3722735.96,"registerCount":194},"banner":[{"imageUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505811103772&di=551be3987492c0a90bdad11f2dc61c79&imgtype=0&src=http%3A%2F%2Fpic.hsw.cn%2F0%2F12%2F25%2F40%2F12254064_630448.jpg","linkUrl":"http://www.baidu.com","id":3,"sort":8}],"article":{"announcementList":[{"imageCoverUrl":"http://192.168.6.93/uploads/20170926/59c9cd33dfae3.jpg","createTime":1504079301000,"homePageCoverUrl":"http://192.168.6.93/uploads/20170926/59c9cd3f34b08.jpg","description":"1儿童沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通个人","id":1,"title":"111","url":"11","content":"1台34认为我无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无"}],"eventList":[{"imageCoverUrl":"http://192.168.6.93/uploads/20170926/59c9cd7a7d206.jpg","createTime":1506397575000,"homePageCoverUrl":"http://192.168.6.93/uploads/20170926/59c9cd7e61495.jpg","description":"2323232323232323232323东方时尚所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所","id":32,"title":"android平太阳","url":"http://www.baidu.com","content":"233333333333333333333333333333速度vsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsd&nbsp;"}]}}
     */

    var model: ModelBean? = null

    class ModelBean {
        /**
         * homestatic : {"income":2265958.64,"amount":3722735.96,"registerCount":194}
         * banner : [{"imageUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505811103772&di=551be3987492c0a90bdad11f2dc61c79&imgtype=0&src=http%3A%2F%2Fpic.hsw.cn%2F0%2F12%2F25%2F40%2F12254064_630448.jpg","linkUrl":"http://www.baidu.com","id":3,"sort":8}]
         * article : {"announcementList":[{"imageCoverUrl":"http://192.168.6.93/uploads/20170926/59c9cd33dfae3.jpg","createTime":1504079301000,"homePageCoverUrl":"http://192.168.6.93/uploads/20170926/59c9cd3f34b08.jpg","description":"1儿童沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通个人","id":1,"title":"111","url":"11","content":"1台34认为我无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无"}],"eventList":[{"imageCoverUrl":"http://192.168.6.93/uploads/20170926/59c9cd7a7d206.jpg","createTime":1506397575000,"homePageCoverUrl":"http://192.168.6.93/uploads/20170926/59c9cd7e61495.jpg","description":"2323232323232323232323东方时尚所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所","id":32,"title":"android平太阳","url":"http://www.baidu.com","content":"233333333333333333333333333333速度vsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsd&nbsp;"}]}
         */

        var homestatic: HomestaticBean? = null
        var article: ArticleBean? = null
        var banner: List<BannerBean>? = null

        class HomestaticBean {
            /**
             * income : 2265958.64
             * amount : 3722735.96
             * registerCount : 194
             */

            var income: String? = null
            var amount: String? = null
            var registerCount: String? = null
        }

        class ArticleBean {
            var announcementList: List<AnnouncementListBean>? = null
            var eventList: List<EventListBean>? = null

            class AnnouncementListBean {
                /**
                 * imageCoverUrl : http://192.168.6.93/uploads/20170926/59c9cd33dfae3.jpg
                 * createTime : 1504079301000
                 * homePageCoverUrl : http://192.168.6.93/uploads/20170926/59c9cd3f34b08.jpg
                 * description : 1儿童沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通沟通个人
                 * id : 1
                 * title : 111
                 * url : 11
                 * content : 1台34认为我无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无无
                 */

                var imageCoverUrl: String? = null
                var createTime: String? = null
                var homePageCoverUrl: String? = null
                var description: String? = null
                var id: String? = null
                var title: String? = null
                var url: String? = null
                var content: String? = null

            }

            class EventListBean {
                /**
                 * imageCoverUrl : http://192.168.6.93/uploads/20170926/59c9cd7a7d206.jpg
                 * createTime : 1506397575000
                 * homePageCoverUrl : http://192.168.6.93/uploads/20170926/59c9cd7e61495.jpg
                 * description : 2323232323232323232323东方时尚所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所
                 * id : 32
                 * title : android平太阳
                 * url : http://www.baidu.com
                 * content : 233333333333333333333333333333速度vsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsdsd&nbsp;
                 */

                var imageCoverUrl: String? = null
                var createTime: String? = null
                var homePageCoverUrl: String? = null
                var description: String? = null
                var id: String? = null
                var title: String? = null
                var url: String? = null
                var content: String? = null

            }
        }

        class BannerBean {
            /**
             * imageUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505811103772&di=551be3987492c0a90bdad11f2dc61c79&imgtype=0&src=http%3A%2F%2Fpic.hsw.cn%2F0%2F12%2F25%2F40%2F12254064_630448.jpg
             * linkUrl : http://www.baidu.com
             * id : 3
             * sort : 8
             */

             var imageUrl: String?=null
            var linkUrl: String? = null
            var id: String? = null
            var sort: String? = null

        }
    }
}

package com.oahgnez.kotlin.ngca.module.novel.data.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */

data class Book(var _id: String,
                var title: String,
                var author: String,
                var shortIntro: String,
                var majorCate: String,
                var minorCate: String,
                var cover: String,
                var site: String,
                var sizetype: Int,
                var superscript: String,
                var contentType: String,
                var allowMonthly: Boolean,
                var banned: Int,
                var latelyFollower: Int,
                var retentionRatio: Double,
                var lastChapter: String,
                var tags: List<String>) : Serializable


/* {
            "_id": "5afaa58c75c0345b392dca9a",
            "title": "龙族Ⅴ：悼亡者的归来",
            "author": "江南",
            "shortIntro": "这是地狱中的魔王们相互撕咬。铁剑和利爪撕裂空气，留下霜冻和火焰的痕迹，血液刚刚飞溅出来，就被高温化作血红色的蒸汽，冲击波在长长的走廊上来来去去，早已没有任何完整的玻璃，连这座建筑物都摇摇欲坠。",
            "majorCate": "奇幻",
            "minorCate": "西方奇幻",
            "cover": "/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2328044%2F2328044_3077a625538f4ef29384ba71e7387736.jpg%2F",
            "site": "zhuishuvip",
            "sizetype": -1,
            "superscript": "",
            "contentType": "txt",
            "allowMonthly": false,
            "banned": 0,
            "latelyFollower": 22528,
            "retentionRatio": 37.41,
            "lastChapter": "第7章 全民公敌(6)",
            "tags": [ ]
        }, */
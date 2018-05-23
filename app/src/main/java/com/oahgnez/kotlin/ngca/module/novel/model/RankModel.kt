package com.oahgnez.kotlin.ngca.module.novel.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */
data class RankModel(var _id: String,
                     var updated: String,
                     var title: String,
                     var tag: String,
                     var cover: String,
                     var icon: String,
                     var __v: Int,
                     var monthRank: String,
                     var shortTitle: String,
                     var created: String,
                     var bigTag: Boolean,
                     var isSub: Boolean,
                     var collapse: Boolean,
                     var new: Boolean,
                     var gender: String,
                     var pripority: Int,
                     var books:List<BookModel>,
                     var id: String,
                     var total: Int) : Serializable

/* "_id": "54d43437d47d13ff21cad58b",
        "updated": "2018-05-21T21:20:08.530Z",
        "title": "追书最热榜 Top100",
        "tag": "manualRank",
        "cover": "/ranking-cover/142319314350435",
        "icon": "/cover/148945782817557",
        "__v": 1488,
        "monthRank": "564d853484665f97662d0810",
        "totalRank": "564d85b6dd2bd1ec660ea8e2",
        "shortTitle": "最热榜",
        "created": "2018-05-22T08:22:59.843Z",
        "biTag": "false",
        "isSub": false,
        "collapse": false,
        "new": true,
        "gender": "female",
        "priority": 250, */
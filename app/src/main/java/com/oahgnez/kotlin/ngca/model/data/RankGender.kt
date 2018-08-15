package com.oahgnez.kotlin.ngca.model.data

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */

data class RankGender(var _id: String?,
                      var title: String?,
                      var cover: String?,
                      var collapse: Boolean?,
                      var monthRank: String?,
                      var totalRank: String?,
                      var shortTitle: String?) : Serializable

/*
 {
            "_id": "54d43709fd6ec9ae04184aa5",
            "title": "本周潜力榜",
            "cover": "/ranking-cover/142319383473238",
            "collapse": false,
            "monthRank": "564eee77e3a44c9f0e5fd7ae",
            "totalRank": "564eeeca5e6ba6ae074f10ec",
            "shortTitle": "潜力榜"
        }, */
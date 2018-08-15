package com.oahgnez.kotlin.ngca.model.data

import java.io.Serializable

/**
 * Created by oahgnez on 2018/8/14.
 */
data class PixivUser(var id: Long,
                     var name: String,
                     var account: String,
                     var profile_image_urls: ProfileImageUrls,
                     var is_followed: Boolean) : Serializable

data class ProfileImageUrls(var medium: String)


/*
{
                "id":490219,
                "name":"Hiten◆三日目東A07a",
                "account":"hiten0000",
                "profile_image_urls":{
                    "medium":"https://i.pximg.net/user-profile/img/2015/10/24/12/24/00/10030981_8bafcf19499580e99a497f1d37b4c03d_170.png"
                },
                "is_followed":false
            },
*/
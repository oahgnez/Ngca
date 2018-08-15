package com.oahgnez.kotlin.ngca.model.data

import com.oahgnez.kotlin.ngca.java.Types
import java.io.Serializable

/**
 * Created by oahgnez on 2018/8/14.
 */
data class PixivImage(var id: Long,
                      var title: String,
                      @Types.PixivType var type: String,
                      var image_urls: ImageUrls,
                      var caption:String,
                      var restrict:Int,
                      var user: PixivUser,
                      var tags:List<Tag>,
                      var create_date:String,
                      var page_count:Int,
                      var height:Int,
                      var width:Int,
//                      var meta_single_page:OrinalImage,
                      var meta_pages:List<OrinalImage>,
                      var total_view:Int,
                      var total_bookmarks:Int,
                      var is_bookmarked:Boolean,
                      var visible:Boolean,
                      var is_muted:Boolean
) : Serializable

data class ImageUrls(var square_medium:String,
                     var medium:String,
                     var large:String):Serializable

data class Tag(var name:String):Serializable

data class OrinalImage(var original_image_url:String=""):Serializable

/*
 {
            "id":70060680,
            "title":"Limonium",
            "type":"illust",
            "image_urls":{
                "square_medium":"https://i.pximg.net/c/360x360_70/img-master/img/2018/08/07/00/39/06/70060680_p0_square1200.jpg",
                "medium":"https://i.pximg.net/c/540x540_70/img-master/img/2018/08/07/00/39/06/70060680_p0_master1200.jpg",
                "large":"https://i.pximg.net/c/600x1200_90/img-master/img/2018/08/07/00/39/06/70060680_p0_master1200.jpg"
            },
            "caption":"C94新刊（<strong><a href="pixiv://illusts/70053558">illust/70053558</a></strong>）表紙です！",
            "restrict":0,
            "user":Object{...},
            "tags":Array[10],
            "tools":[
                "SAI",
                "Photoshop"
            ],
            "create_date":"2018-08-07T00:39:06+09:00",
            "page_count":1,
            "width":1000,
            "height":1416,
            "sanity_level":2,
            "series":null,
            "meta_single_page":{
                "original_image_url":"https://i.pximg.net/img-original/img/2018/08/07/00/39/06/70060680_p0.png"
            },
            "meta_pages":Array[0],
            "total_view":129689,
            "total_bookmarks":29161,
            "is_bookmarked":false,
            "visible":true,
            "is_muted":false

*/
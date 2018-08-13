package com.oahgnez.kotlin.ngca.module.novel.data.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */

/*{ "name":"玄幻",
"bookCount":521830,
"monthlyCount":21973,
"icon":"/icon/玄幻_.png",
"bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F1228859_fac7917a960547eb953edf0b740cef3a.jpg%2F",
"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F891697%2F891697_89791245d3204520928c0666006c465d.jpg%2F",
"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41584%2F41584_873f1d8b2f7a447a8c59f3573094db1b.jpg%2F"] }*/

/**
 * 具体类别*/
data class Major(var name: String,
                 var bookCount: Int,
                 var monthlyCount: Int,
                 var icon: String,
                 var bookCover: List<String>):Serializable

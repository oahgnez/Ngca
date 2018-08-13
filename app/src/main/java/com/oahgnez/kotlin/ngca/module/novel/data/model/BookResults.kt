package com.oahgnez.kotlin.ngca.module.novel.data.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */
data class BookResults(var total: Int,
                       var ok: Boolean,
                       var books: List<Book>) : Serializable
package com.oahgnez.kotlin.ngca.module.novel.model

import java.io.Serializable

/**
 * Created by oahgnez on 2018/5/22.
 */
data class BooksModel(var total: Int,
                      var ok: Boolean,
                      var books: List<BookModel>) : Serializable
package com.son.module.borad.domain

import com.son.module.BaseEntity
import java.util.Collections.emptyList


data class Post(
    var id: Long = 0L,
    var title: String,
    var content: String,
    var tags: List<String> = emptyList(),
    var comments: MutableList<Comment> = emptyList(),
) : BaseEntity() {

}

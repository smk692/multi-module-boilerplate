package com.son.module.borad.domain

import com.son.module.BaseEntity

open class Tag(
    var id: Long = 0L,
    var name: String,
    var post: Post,
) : BaseEntity() {

}

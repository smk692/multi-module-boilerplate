package com.son.module.borad.domain

import com.son.module.BaseEntity

class Like(
    var id: Long = 0L,
    var post: Post,
) : BaseEntity() {

}

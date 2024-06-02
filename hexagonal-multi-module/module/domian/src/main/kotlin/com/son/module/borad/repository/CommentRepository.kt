package com.son.module.borad.repository

import com.son.module.borad.domain.Comment

interface CommentRepository {
    fun findById(id: Long): Comment

    fun findByAll(): List<Comment>

}

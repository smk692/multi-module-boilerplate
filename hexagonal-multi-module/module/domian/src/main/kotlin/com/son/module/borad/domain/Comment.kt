package com.son.module.borad.domain

import com.son.module.borad.dto.CommentUpdateRequestDto
import com.son.module.borad.exception.CommentNotUpdatableException
import com.son.module.BaseEntity

data class Comment(
    var id: Long = 0L,
    var content: String,
    var post: Post,
) : BaseEntity() {
    fun update(updateRequestDto: CommentUpdateRequestDto) {
        if (updateRequestDto.updatedBy != this.createdBy) {
            throw CommentNotUpdatableException()
        }
        this.content = updateRequestDto.content
    }
}

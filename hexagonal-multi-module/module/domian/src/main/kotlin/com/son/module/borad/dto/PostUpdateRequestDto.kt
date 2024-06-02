package com.son.module.borad.dto

import com.son.module.BaseEntity
import java.util.Collections.emptyList

data class PostUpdateRequestDto(
    val title: String,
    val content: String,
    val updateBy: String,
    val tag: List<String> = emptyList(),

): BaseEntity()

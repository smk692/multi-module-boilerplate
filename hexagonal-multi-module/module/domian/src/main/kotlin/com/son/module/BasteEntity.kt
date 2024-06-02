package com.son.module

import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime


@MappedSuperclass
abstract class BaseEntity() {
    var createdBy: String? = null
        protected set

    val createdAt: LocalDateTime = LocalDateTime.now()

    var updatedBy: String? = null
        protected set
    var updatedAt: LocalDateTime? = null
        protected set

    fun updatedBy(updatedBy: String) {
        this.updatedBy = updatedBy
        this.updatedAt = LocalDateTime.now()
    }
}

package kr.co.kotlin.domain.user.repository

import kr.co.kotlin.domain.user.domain.User

interface UserRepository {
    fun findByIdOrNull(id: Long): User?

    fun create(user: User): User
}

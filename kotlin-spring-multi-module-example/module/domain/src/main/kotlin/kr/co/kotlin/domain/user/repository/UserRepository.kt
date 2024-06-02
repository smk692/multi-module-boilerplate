package kr.co.kotlin.domain.user.repository

import kr.co.kotlin.domain.user.model.User

interface UserRepository {
    fun findByIdOrNull(id: Long): User?

    fun findByUserName(userName: String): User?

    fun create(user: User)

    fun update(user: User)

    fun update2(user: User)

    fun update3(user: User)

    fun update4(user: User)
}

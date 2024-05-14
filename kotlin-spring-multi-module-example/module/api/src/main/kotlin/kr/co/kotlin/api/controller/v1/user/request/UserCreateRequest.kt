package kr.co.kotlin.api.controller.v1.user.request

import kr.co.kotlin.domain.user.domain.User

data class UserCreateRequest(
    val username: String,
    val email: String
) {
    fun toDomain(): User {
        return User(
            username = username,
            email = email
        )
    }
}

package kr.co.kotlin.api.controller.user.request

import kr.co.kotlin.domain.user.model.User

data class UserCreateRequestDto(
    val username: String,
    val email: String
) {
    fun toDomain(): User {
        return User(
            userName = username,
            email = email
        )
    }
}

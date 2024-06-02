package kr.co.kotlin.api.controller.user.response

import kr.co.kotlin.domain.user.model.User

data class UserResponseDto(
    val id: Long,
    val username: String,
    val email: String
) {
    companion object {
        fun fromDomain(domain: User): UserResponseDto {
            return UserResponseDto(
                id = domain.id,
                username = domain.userName,
                email = domain.email
            )
        }
    }
}

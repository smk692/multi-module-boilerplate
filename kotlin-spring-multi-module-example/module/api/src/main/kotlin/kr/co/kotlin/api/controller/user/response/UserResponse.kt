package kr.co.kotlin.api.controller.user.response

import kr.co.kotlin.domain.user.domain.User

data class UserResponse(
    val id: Long,
    val username: String,
    val email: String
) {
    companion object {
        fun fromDomain(domain: User): UserResponse {
            return UserResponse(
                id = domain.id,
                username = domain.username,
                email = domain.email
            )
        }
    }
}

package kr.co.kotlin.domain.user.domain

data class User(
    val id: Long = 0,
    val userName: String,
    val email: String
) {
    fun updateUserName(username: String): User {
        return this.copy(userName = username)
    }
}

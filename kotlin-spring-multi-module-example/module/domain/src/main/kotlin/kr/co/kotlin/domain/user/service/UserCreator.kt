package kr.co.kotlin.domain.user.service

import kr.co.kotlin.domain.user.repository.UserRepository
import kr.co.kotlin.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserCreator(
    private val userRepository: UserRepository
) {
    fun createUser(user: User) {
        userRepository.create(user)
    }
}

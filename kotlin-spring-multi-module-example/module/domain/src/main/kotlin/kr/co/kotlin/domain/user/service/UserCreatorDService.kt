package kr.co.kotlin.domain.user.service

import kr.co.kotlin.domain.config.annotation.DomainService
import kr.co.kotlin.domain.user.repository.UserRepository
import kr.co.kotlin.domain.user.domain.User

@DomainService
class UserCreatorDService(
    private val userRepository: UserRepository
) {
    fun createUser(user: User): User {
        return userRepository.create(user)
    }
}

package kr.co.kotlin.domain.user.service

import kr.co.kotlin.domain.config.annotation.DomainService
import kr.co.kotlin.domain.user.repository.UserRepository
import kr.co.kotlin.domain.user.model.User

@DomainService
class UserReaderDService(
    private val userRepository: UserRepository
) {
    fun findByIdOrNull(id: Long): User {
        return userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("User not found")
    }
}

package kr.co.kotlin.domain.user.service

import kr.co.kotlin.domain.user.repository.UserRepository
import kr.co.kotlin.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserReader(
    private val userRepository: UserRepository
) {
    fun findByIdOrNull(id: Long): User? {
        return userRepository.findByIdOrNull(id)
    }
}

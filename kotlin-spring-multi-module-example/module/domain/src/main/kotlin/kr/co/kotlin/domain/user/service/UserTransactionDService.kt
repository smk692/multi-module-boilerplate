package kr.co.kotlin.domain.user.service

import kr.co.kotlin.domain.config.annotation.DomainService
import kr.co.kotlin.domain.user.repository.UserRepository
import kr.co.kotlin.domain.user.model.User
import org.springframework.transaction.annotation.Transactional

@DomainService
class UserTransactionDService(
    private val userRepository: UserRepository
) {
    fun createUser(user: User): Long {
        userRepository.create(user)
        return user.id
    }

    @Transactional
    fun updateUser(id: Long, userName: String): Long {
        val user = userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("User not found")
        user.updateUserName(userName)

        userRepository.update(user)
        return id
    }

}

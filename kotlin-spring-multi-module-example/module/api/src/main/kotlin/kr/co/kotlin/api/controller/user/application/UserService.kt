package kr.co.kotlin.api.controller.user.application

import kr.co.kotlin.api.controller.user.request.UserCreateRequestDto
import kr.co.kotlin.api.controller.user.request.UserUpdateRequestDto
import kr.co.kotlin.domain.user.model.User
import kr.co.kotlin.domain.user.service.UserReaderDService
import kr.co.kotlin.domain.user.service.UserTransactionDService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class UserService(
    private val userTransactionDService: UserTransactionDService,
    private val userReaderDService: UserReaderDService,
) {
    fun findUserById(id: Long): User {
        return userReaderDService.findByIdOrNull(id)
    }

    @Transactional
    fun createUser(userCreateRequestDto: UserCreateRequestDto): Long {
        return userTransactionDService.createUser(userCreateRequestDto.toDomain())
    }

    @Transactional
    fun updateUser(id: Long, userUpdateRequestDto: UserUpdateRequestDto): Long {
        return userTransactionDService.updateUser(id, userUpdateRequestDto.userName)
    }
}

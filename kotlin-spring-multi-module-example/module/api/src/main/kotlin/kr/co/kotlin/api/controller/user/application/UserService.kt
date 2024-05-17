package kr.co.kotlin.api.controller.user.application

import kr.co.kotlin.api.controller.user.request.UserCreateRequestDto
import kr.co.kotlin.domain.user.domain.User
import kr.co.kotlin.domain.user.service.UserCreatorDService
import kr.co.kotlin.domain.user.service.UserReaderDService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userCreator: UserCreatorDService,
    private val userReaderDService: UserReaderDService
) {
    fun createUser(userCreateRequestDto: UserCreateRequestDto): User {
        return userCreator.createUser(userCreateRequestDto.toDomain())
    }

    fun findUserById(id: Long): User {
        return userReaderDService.findByIdOrNull(id)
    }
}

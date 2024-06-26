package kr.co.kotlin.api.controller.user.api

import kr.co.kotlin.api.controller.user.application.UserService
import kr.co.kotlin.api.controller.user.request.UserCreateRequestDto
import kr.co.kotlin.api.controller.user.request.UserUpdateRequestDto
import kr.co.kotlin.api.controller.user.response.UserResponseDto
import kr.co.kotlin.support.util.response.Response

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService,
) {
    @GetMapping("/{id}")
    fun findUserById(@PathVariable("id") id: Long): Response<UserResponseDto> {
        val findUser = userService.findUserById(id)
        return Response.success(UserResponseDto.fromDomain(findUser))
    }

    @PostMapping
    fun createUser(@RequestBody userCreateRequestDto: UserCreateRequestDto): Response<Long> {
        val userId = userService.createUser(userCreateRequestDto)
        return Response.success(userId)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userUpdateRequestDto: UserUpdateRequestDto): Response<Long> {
        val userId = userService.updateUser(id, userUpdateRequestDto)
        return Response.success(userId)
    }
}

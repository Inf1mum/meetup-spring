package ru.tbank.meetupspring.controller.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.tbank.meetupspring.entity.User
import ru.tbank.meetupspring.service.UserService


@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/users")
    fun findAll(): List<UserDto> {
        return userService.findAll().map { toUserDto(it) }
    }

    @GetMapping("/users/{id}")
    fun findById(@PathVariable id: String): UserDto {
        return toUserDto(userService.getById(id))
    }

    @PostMapping("/users")
    fun save(@RequestBody userCreateDto: UserCreateDto): UserDto {
        val user = toUser(userCreateDto)
        return toUserDto(userService.save(user))
    }

    private fun toUserDto(user: User) = UserDto(user.id.toString(), user.firstName, user.lastName, user.email)

    private fun toUser(dto: UserCreateDto) = User(firstName = dto.firstName, lastName = dto.lastName, email = dto.email)
}



package ru.tbank.meetupspring.repository

import org.springframework.data.repository.CrudRepository
import ru.tbank.meetupspring.entity.User

interface UserRepository : CrudRepository<User, String?> {
    fun getById(id: String): User = findById(id).orElseThrow { RuntimeException("User does not exist") }
}

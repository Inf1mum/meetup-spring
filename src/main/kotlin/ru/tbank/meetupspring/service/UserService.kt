package ru.tbank.meetupspring.service

import org.springframework.stereotype.Service
import ru.tbank.meetupspring.entity.User
import ru.tbank.meetupspring.kafka.producer.UserCreateProducer
import ru.tbank.meetupspring.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userCreateProducer: UserCreateProducer
) {
    fun findAll(): List<User> {
        return userRepository.findAll().toList()
    }

    fun getById(id: String): User {
        return userRepository.getById(id)
    }

    fun save(user: User): User {
        return userRepository.save(user).also { userCreateProducer.produce(it) }
    }
}

package ru.tbank.meetupspring.kafka.listener

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class UserCreateListener {
    private val log = LoggerFactory.getLogger(UserCreateListener::class.java)

    @KafkaListener(id = "\${spring.kafka.topics.user-create.group-id}", topics = ["\${spring.kafka.topics.user-create.name}"])
    fun listen(message: String?) {
        log.info(message)
    }
}

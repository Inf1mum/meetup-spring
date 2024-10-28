package ru.tbank.meetupspring.kafka.producer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import ru.tbank.meetupspring.entity.User
import ru.tbank.meetupspring.kafka.event.UserCreateEvent

@Component
class UserCreateProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper,
    @Value("\${spring.kafka.topics.user-create.name}") private val userCreateTopic: String
) {
    fun produce(user: User) {
        kafkaTemplate.send(userCreateTopic, objectMapper.writeValueAsString(
            UserCreateEvent(user.id.toString(), user.firstName, user.lastName, user.email)
        ))
    }

}

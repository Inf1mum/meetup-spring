package ru.tbank.meetupspring.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "integration.dog-fact")
data class DogProperty(
    val host: String
)

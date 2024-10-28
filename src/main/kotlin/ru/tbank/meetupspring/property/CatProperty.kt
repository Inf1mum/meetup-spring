package ru.tbank.meetupspring.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "integration.cat-fact")
data class CatProperty(
    val host: String
)

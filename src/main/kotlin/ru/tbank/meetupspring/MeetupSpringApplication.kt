package ru.tbank.meetupspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories("ru.tbank.meetupspring.repository")
@ConfigurationPropertiesScan
@SpringBootApplication
class MeetupSpringApplication

fun main(args: Array<String>) {
    runApplication<MeetupSpringApplication>(*args)
}

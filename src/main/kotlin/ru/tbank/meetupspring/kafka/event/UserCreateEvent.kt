package ru.tbank.meetupspring.kafka.event


data class UserCreateEvent(
    val id : String,
    val firstName: String,
    val lastName: String,
    val email: String
)

package ru.tbank.meetupspring.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class User(
    @Id
    var id : String? = null,
    val firstName: String,
    val lastName: String,
    val email: String
)

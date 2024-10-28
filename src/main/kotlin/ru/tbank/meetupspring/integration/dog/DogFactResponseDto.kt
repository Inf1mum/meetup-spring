package ru.tbank.meetupspring.integration.dog

data class DogFactResponseDto(
    val data: List<DogFactData>,
)

data class DogFactData(
    val id: String,
    val type: String,
    val attributes: DogFactAttributes
)

data class DogFactAttributes(
    val body: String,
)

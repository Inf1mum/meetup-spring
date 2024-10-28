package ru.tbank.meetupspring.integration.dog

import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import ru.tbank.meetupspring.model.DogFact
import ru.tbank.meetupspring.property.DogProperty

@Service
class DogService(
    dogProperty: DogProperty
) {
    private val restClient = RestClient.create(dogProperty.host)

    fun findAny(): DogFact {
        return restClient.get()
            .uri("/facts")
            .retrieve()
            .body(DogFactResponseDto::class.java)
            .let { DogFact(fact = it?.data?.first()?.attributes?.body.orEmpty(), id = it?.data?.first()?.id.orEmpty()) }
    }
}

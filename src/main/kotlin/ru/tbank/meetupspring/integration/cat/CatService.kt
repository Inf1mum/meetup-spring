package ru.tbank.meetupspring.integration.cat

import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import ru.tbank.meetupspring.model.CatFact
import ru.tbank.meetupspring.property.CatProperty

@Service
class CatService(
    catProperty: CatProperty
) {
    private val restClient = RestClient.create(catProperty.host)

    fun findAny(): CatFact {
        return restClient.get()
            .uri("/fact")
            .retrieve()
            .body(CatFactResponseDto::class.java)
            .let { CatFact(fact = it?.fact.orEmpty(), length = it?.length ?: 0) }
    }
}

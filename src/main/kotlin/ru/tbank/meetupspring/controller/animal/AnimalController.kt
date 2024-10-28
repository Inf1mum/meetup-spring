package ru.tbank.meetupspring.controller.animal

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.tbank.meetupspring.integration.cat.CatService
import ru.tbank.meetupspring.integration.dog.DogService
import ru.tbank.meetupspring.model.CatFact

@RestController
class AnimalController(
    private val catService: CatService,
    private val dogService: DogService
) {

    @GetMapping("/cat/fact")
    fun getCatFact() : CatFactDto {
        return catService.findAny().let { CatFactDto(it.fact, it.length) }
    }


    @GetMapping("/dog/fact")
    fun getDogFact() : DogFactDto {
        return dogService.findAny().let { DogFactDto(it.id, it.fact) }
    }
}

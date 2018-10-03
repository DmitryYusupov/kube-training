package ru.yusdm.kubetraining.country.nonereactive.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.yusdm.kubetraining.country.common.dto.CountryDTO
import ru.yusdm.kubetraining.country.nonereactive.controllers.CountryRestController.Companion.PATH
import ru.yusdm.kubetraining.country.nonereactive.extensions.toDto
import ru.yusdm.kubetraining.country.nonereactive.extensions.toJPA
import ru.yusdm.kubetraining.country.nonereactive.service.CountryJpaService
import kotlin.streams.toList

@RestController
@RequestMapping(value = [PATH])
class CountryRestController(val countryJpaService: CountryJpaService) {

    companion object {
        const val PATH = "/country/simplerest"
    }

    @GetMapping(value = ["/ping"])
    fun ping() = "This is ping"

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    fun getAll(): List<CountryDTO> {
        return countryJpaService.findAll().stream().map { it.toDto() }.toList()
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): ResponseEntity<CountryDTO> {
        val optionalCountry = countryJpaService.findById(id)
        return optionalCountry.map {
            ResponseEntity.ok(it.toDto())
        }.orElseGet { ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        countryJpaService.deleteById(id)
    }

    @PostMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun save(@RequestBody country: CountryDTO): CountryDTO {
        return countryJpaService.saveUpdate(country.toJPA()).toDto()
    }

    @PutMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun update(@RequestBody country: CountryDTO): CountryDTO {
        return countryJpaService.saveUpdate(country.toJPA()).toDto()
    }
}
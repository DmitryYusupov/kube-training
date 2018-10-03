package ru.ysdm.kubetraining.city.nonereactive.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.ysdm.kubetraining.city.common.dto.CityDTO
import ru.ysdm.kubetraining.city.nonereactive.extensions.toDto
import ru.ysdm.kubetraining.city.nonereactive.extensions.toJPA
import ru.ysdm.kubetraining.city.nonereactive.service.CityJpaService
import kotlin.streams.toList

@RestController
class CityRestController(val cityJpaService: CityJpaService) {
    companion object {
        const val PATH = "city/simplerest"
    }

    @GetMapping(value = ["/ping"])
    fun ping() = "This is ping"

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(): List<CityDTO> {
        return cityJpaService.findAll().stream().map { it.toDto() }.toList()
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): ResponseEntity<CityDTO> {
        val optionalCity = cityJpaService.findById(id)
        return optionalCity.map {
            ResponseEntity.ok(it.toDto())
        }.orElseGet { ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        cityJpaService.deleteById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun save(@RequestBody city: CityDTO): CityDTO {
        return cityJpaService.saveUpdate(city.toJPA()).toDto()
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody city: CityDTO): CityDTO {
        return cityJpaService.saveUpdate(city.toJPA()).toDto()
    }
}
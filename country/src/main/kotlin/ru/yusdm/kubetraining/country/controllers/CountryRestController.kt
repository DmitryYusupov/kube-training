package ru.yusdm.kubetraining.country.controllers

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import ru.yusdm.kubetraining.common.business.dto.CityDTO
import ru.yusdm.kubetraining.common.business.dto.CountryDTO
import ru.yusdm.kubetraining.country.common.configs.WebConfigs
import ru.yusdm.kubetraining.country.controllers.CountryRestController.Companion.PATH
import ru.yusdm.kubetraining.country.extensions.toDto
import ru.yusdm.kubetraining.country.extensions.toJPA
import ru.yusdm.kubetraining.country.integration.CityAmbassadorFeignClient
import ru.yusdm.kubetraining.country.integration.CityFeignClient
import ru.yusdm.kubetraining.country.service.CountryJpaService
import kotlin.streams.toList

@RestController
@RequestMapping(value = [PATH])
class CountryRestController(val countryJpaService: CountryJpaService,
                            val cityFeignClient: CityFeignClient,
                            val cityAmbassadorFeignClient: CityAmbassadorFeignClient,
                            val restTemplate: RestTemplate,
                            val webConfigs: WebConfigs) {

    companion object {
        const val PATH = "/simplerest"
    }

    //------Simple feign Begin------------------------------
    @GetMapping(value = ["/feign/city/all"])
    fun getAllCitiesWithFeign(): MutableList<CityDTO> {
        return cityFeignClient.getAllCities()
    }

    @GetMapping(value = ["/feign/city/ping"])
    fun pingCityServiceWithFeign(): String {
        return cityFeignClient.pingCityService()
    }
    //------Simple feign End------------------------------


    //------Ambassador feign Begin------------------------------
    @GetMapping(value = ["/feign/ambassador/city/all"])
    fun getAllCitiesWithAmbassadorFeign(): MutableList<CityDTO> {
        return cityAmbassadorFeignClient.getAllCities()
    }

    @GetMapping(value = ["/feign/ambassador/city/ping"])
    fun pingCityServiceWithAmbassadorFeign(): String {
        return cityAmbassadorFeignClient.pingCityService()
    }
    //------Ambassador feign End------------------------------


    //------Load balanced RestTemplate with cityService Begin-------------------
    /**
     * See comments in WebConfigs.class
     */
    @GetMapping(value = ["/loadbalancedresttemplate/city/all"])
    fun getAllCitiesWithLoadBalancedRestTemplate(): List<CityDTO> {
        val url = webConfigs.getCityServiceRibbonHttpUrl() + "/simplerest"
        val resp: ResponseEntity<List<CityDTO>> = restTemplate.exchange(url, GET, null,
                object : ParameterizedTypeReference<List<CityDTO>>() {})
        return resp.body ?: emptyList()
    }

    @GetMapping(value = ["/loadbalancedresttemplate/city/ping"])
    fun pingCityServiceWithLoadBalancedRestTemplate(): String? {
        return restTemplate.getForObject(webConfigs.getCityServiceRibbonHttpUrl() + "/simplerest/ping", String::class.java)
    }
    //------Load balanced RestTemplate with cityService End-------------------


    //------Load balanced RestTemplate with ambassador Begin-------------------
    @GetMapping(value = ["/loadbalancedresttemplate/ambassador/city/all"])
    fun getAllCitiesWithAmbassadorLoadBalancedRestTemplate(): List<CityDTO> {
        val cityAmbassadorUrl = webConfigs.getAmbassadorRibbonHttpUrl() + CityAmbassadorFeignClient.REST_PREFIX
        val resp: ResponseEntity<List<CityDTO>> = restTemplate.exchange(cityAmbassadorUrl, GET, null,
                object : ParameterizedTypeReference<List<CityDTO>>() {})
        return resp.body ?: emptyList()
    }

    @GetMapping(value = ["/loadbalancedresttemplate/ambassador/city/ping"])
    fun pingCityServiceWithAmbassadorLoadBalancedRestTemplate(): String? {
        val cityAmbassadorUrl = webConfigs.getAmbassadorRibbonHttpUrl() + CityAmbassadorFeignClient.REST_PREFIX
        return restTemplate.getForObject("$cityAmbassadorUrl/ping", String::class.java)
    }
    //------Load balanced RestTemplate with ambassador Begin-------------------


    //------RestTemplate with cityService Begin-------------------
    /**
     * See comments in WebConfigs.class
     */
    @GetMapping(value = ["/resttemplate/city/all"])
    fun getAllCitiesWithRestTemplate(): List<CityDTO> {
        val restTemplate = RestTemplate()
        val url = webConfigs.getCityServiceHttpUrl() + "/simplerest"
        val resp: ResponseEntity<List<CityDTO>> = restTemplate.exchange(url, GET, null,
                object : ParameterizedTypeReference<List<CityDTO>>() {})
        return resp.body ?: emptyList()
    }

    @GetMapping(value = ["/resttemplate/city/ping"])
    fun pingCityServiceWithRestTemplate(): String? {
        val restTemplate = RestTemplate()
        return restTemplate.getForObject(webConfigs.getCityServiceHttpUrl() + "/simplerest/ping", String::class.java)
    }
    //------RestTemplate with cityService End-------------------


    //------RestTemplate with ambassador Begin-------------------
    @GetMapping(value = ["/resttemplate/ambassador/city/all"])
    fun getAllCitiesWithAmbassadorRestTemplate(): List<CityDTO> {
        val restTemplate = RestTemplate()
        val cityAmbassadorUrl = webConfigs.getAmbassadorHttpUrl() + CityAmbassadorFeignClient.REST_PREFIX
        val resp: ResponseEntity<List<CityDTO>> = restTemplate.exchange(cityAmbassadorUrl, GET, null,
                object : ParameterizedTypeReference<List<CityDTO>>() {})
        return resp.body ?: emptyList()

    }

    @GetMapping(value = ["/resttemplate/ambassador/city/ping"])
    fun pingCityServiceWithAmbassadorRestTemplate(): String? {
        val restTemplate = RestTemplate()
        val cityAmbassadorUrl = webConfigs.getAmbassadorHttpUrl() + CityAmbassadorFeignClient.REST_PREFIX
        return restTemplate.getForObject("$cityAmbassadorUrl/ping", String::class.java)
    }
    //------RestTemplate with ambassador Begin-------------------


    @GetMapping(value = ["/ping"])
    fun ping() = "This is ping (CountryRest)"

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
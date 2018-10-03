package ru.yusdm.kubetraining.country.nonereactive.integration

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import ru.yusdm.kubetraining.common.business.dto.CityDTO
import ru.yusdm.kubetraining.country.common.configs.CountryServiceConfigs

@FeignClient(name = CountryServiceConfigs.CITY_KUBERNETES_SERVICE)
interface CityFeignClient {

    companion object {
        private const val REST_PREFIX = "/simplerest"
    }

    @GetMapping("$REST_PREFIX/ping")
    fun pingCityService(): String

    @GetMapping(REST_PREFIX)
    fun getAllCities() : MutableList<CityDTO>

}
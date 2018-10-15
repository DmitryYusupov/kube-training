package ru.yusdm.kubetraining.country.integration

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import ru.yusdm.kubetraining.common.business.dto.CityDTO
import ru.yusdm.kubetraining.country.common.configs.CountryServiceConfigs

@FeignClient(name = CountryServiceConfigs.AMBASSADOR_KUBERNETES_SERVICE)
interface CityAmbassadorFeignClient {
    companion object {
         const val REST_PREFIX = "/api/ambassador/city/simplerest"
    }

    @GetMapping("$REST_PREFIX/ping")
    fun pingCityService(): String

    @GetMapping(REST_PREFIX)
    fun getAllCities() : MutableList<CityDTO>

}
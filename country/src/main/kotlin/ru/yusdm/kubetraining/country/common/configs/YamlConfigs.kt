package ru.yusdm.kubetraining.country.common.configs

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class YamlConfigs {

    companion object {
        const val SERVICE_PREFIX = "custom.services."
        const val CITY_SERVICE_PREFIX = "${SERVICE_PREFIX}cityservice."
    }

    @Value("\${" + CITY_SERVICE_PREFIX + "logicalName}")
    lateinit var cityService: String

    @Value("\${" + SERVICE_PREFIX + "ambassadorservice.logicalName}")
    lateinit var ambassadorService: String
}


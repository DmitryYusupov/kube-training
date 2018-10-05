package ru.yusdm.kubetraining.country.common.configs

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class YamlConfigs {

    companion object {
        const val SERVICE_PREFIX = "custom.services."
        const val CITY_SERVICE_PREFIX = "${SERVICE_PREFIX}cityservice."
        const val AMBASSADOR_SERVICE_PREFIX = "${SERVICE_PREFIX}ambassadorservice."
    }

    @Value("\${" + CITY_SERVICE_PREFIX + "dnsName}")
    lateinit var cityServiceDnsName: String

    @Value("\${" + CITY_SERVICE_PREFIX + "port}")
    lateinit var cityServicePort: String

    @Value("\${" + AMBASSADOR_SERVICE_PREFIX + "dnsName}")
    lateinit var ambassadorServiceDnsName: String

    @Value("\${" + AMBASSADOR_SERVICE_PREFIX + "port}")
    lateinit var ambassadorServicePort: String
}


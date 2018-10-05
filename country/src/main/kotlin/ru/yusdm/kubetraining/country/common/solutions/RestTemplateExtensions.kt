package ru.yusdm.kubetraining.country.common.solutions

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

fun <T> RestTemplate.simpleExchangeGet(url: String): ResponseEntity<T> {
    return this.exchange(
            url,
            HttpMethod.GET,
            HttpEntity.EMPTY,
            object : ParameterizedTypeReference<T>() {}
    )
}

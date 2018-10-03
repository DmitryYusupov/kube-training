package ru.yusdm.kubetraining.country

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients


@SpringBootApplication
@EnableFeignClients
class CountryApplication

fun main(args: Array<String>) {
    runApplication<CountryApplication>(*args)
}

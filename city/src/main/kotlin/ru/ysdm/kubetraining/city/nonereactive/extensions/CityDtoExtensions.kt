package ru.ysdm.kubetraining.city.nonereactive.extensions

import ru.ysdm.kubetraining.city.common.dto.CityDTO
import ru.ysdm.kubetraining.city.nonereactive.domain.CityJpaEntity

fun CityDTO.toJPA() = CityJpaEntity().apply {
    id = this@toJPA.id
    countryId = this@toJPA.countryId
    mainStreet = this@toJPA.mainStreet
    description = this@toJPA.description
    name = this@toJPA.name
}


package ru.ysdm.kubetraining.city.nonereactive.extensions


import ru.ysdm.kubetraining.city.nonereactive.domain.CityJpaEntity
import ru.yusdm.kubetraining.common.business.dto.CityDTO

fun CityDTO.toJPA() = CityJpaEntity().apply {
    id = this@toJPA.id
    countryId = this@toJPA.countryId
    mainStreet = this@toJPA.mainStreet
    description = this@toJPA.description
    name = this@toJPA.name
}


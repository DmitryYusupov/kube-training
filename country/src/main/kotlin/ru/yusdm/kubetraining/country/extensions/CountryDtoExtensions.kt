package ru.yusdm.kubetraining.country.extensions


import ru.yusdm.kubetraining.common.business.dto.CountryDTO
import ru.yusdm.kubetraining.country.domain.CountryJpaEntity

fun CountryDTO.toJPA() = CountryJpaEntity().apply {
    id = this@toJPA.id
    description = this@toJPA.description
    name = this@toJPA.name
}


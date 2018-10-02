package ru.yusdm.kubetraining.country.jpa.extensions

import ru.yusdm.kubetraining.country.common.dto.CountryDTO
import ru.yusdm.kubetraining.country.jpa.domain.CountryJpaEntity

fun CountryDTO.toJPA() = CountryJpaEntity().apply {
    id = this@toJPA.id
    description = this@toJPA.description
    name = this@toJPA.name
}


package ru.yusdm.kubetraining.country.nonereactive.extensions


import ru.yusdm.kubetraining.common.business.dto.CountryDTO
import ru.yusdm.kubetraining.country.nonereactive.domain.CountryJpaEntity

fun CountryJpaEntity.toDto() = CountryDTO().apply {
    this.id  = this@toDto.id
    this.name = this@toDto.name
    this.description = this@toDto.description
}

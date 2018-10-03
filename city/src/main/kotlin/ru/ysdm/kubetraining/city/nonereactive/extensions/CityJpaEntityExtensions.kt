package ru.ysdm.kubetraining.city.nonereactive.extensions

import ru.ysdm.kubetraining.city.common.dto.CityDTO
import ru.ysdm.kubetraining.city.nonereactive.domain.CityJpaEntity

fun CityJpaEntity.toDto(): CityDTO {
    return CityDTO().apply {
        id = this@toDto.id
        name = this@toDto.name
        countryId = this@toDto.countryId
        description = this@toDto.description
        mainStreet = this@toDto.mainStreet
    }
}

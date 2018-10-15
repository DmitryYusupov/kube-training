package ru.ysdm.kubetraining.city.extensions

import ru.ysdm.kubetraining.city.domain.CityJpaEntity
import ru.yusdm.kubetraining.common.business.dto.CityDTO

fun CityJpaEntity.toDto(): CityDTO {
    return CityDTO().apply {
        id = this@toDto.id
        name = this@toDto.name
        countryId = this@toDto.countryId
        description = this@toDto.description
        mainStreet = this@toDto.mainStreet
    }
}

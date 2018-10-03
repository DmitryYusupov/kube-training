package ru.yusdm.kubetraining.country.nonereactive.extensions

import ru.yusdm.kubetraining.country.common.dto.CountryDTO
import ru.yusdm.kubetraining.country.nonereactive.domain.CountryJpaEntity

fun CountryJpaEntity.toDto() = CountryDTO(this.id, this.name, this.description)

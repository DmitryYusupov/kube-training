package ru.yusdm.kubetraining.country.jpa.extensions

import ru.yusdm.kubetraining.country.common.dto.CountryDTO
import ru.yusdm.kubetraining.country.jpa.domain.CountryJpaEntity

fun CountryJpaEntity.toDto() = CountryDTO(this.id, this.name, this.description)

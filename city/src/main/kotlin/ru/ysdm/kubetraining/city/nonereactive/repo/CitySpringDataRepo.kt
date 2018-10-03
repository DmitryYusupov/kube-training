package ru.ysdm.kubetraining.city.nonereactive.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.ysdm.kubetraining.city.nonereactive.domain.CityJpaEntity

interface CitySpringDataRepo : JpaRepository<CityJpaEntity, Long> {
    fun findByCountryId(countryId: Long): MutableList<CityJpaEntity>
}


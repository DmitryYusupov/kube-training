package ru.ysdm.kubetraining.city.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.ysdm.kubetraining.city.domain.CityJpaEntity

interface CitySpringDataRepo : JpaRepository<CityJpaEntity, Long> {
    fun findByCountryId(countryId: Long): MutableList<CityJpaEntity>
}


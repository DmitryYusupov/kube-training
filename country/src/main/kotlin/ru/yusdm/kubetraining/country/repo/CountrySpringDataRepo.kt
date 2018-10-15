package ru.yusdm.kubetraining.country.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.kubetraining.country.domain.CountryJpaEntity

interface CountrySpringDataRepo : JpaRepository<CountryJpaEntity, Long>

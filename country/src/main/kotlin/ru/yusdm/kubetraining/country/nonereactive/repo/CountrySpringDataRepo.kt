package ru.yusdm.kubetraining.country.nonereactive.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.kubetraining.country.nonereactive.domain.CountryJpaEntity

interface CountrySpringDataRepo : JpaRepository<CountryJpaEntity, Long>

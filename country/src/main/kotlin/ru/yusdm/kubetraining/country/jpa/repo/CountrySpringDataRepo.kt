package ru.yusdm.kubetraining.country.jpa.repo

import org.springframework.data.jpa.repository.JpaRepository
import ru.yusdm.kubetraining.country.jpa.domain.CountryJpaEntity

interface CountrySpringDataRepo : JpaRepository<CountryJpaEntity, Long>

package ru.yusdm.kubetraining.country.jpa.service

import ru.yusdm.kubetraining.country.jpa.domain.CountryJpaEntity
import java.util.*

interface CountryJpaService {

    fun findAll(): MutableList<CountryJpaEntity>
    fun findById(id: Long): Optional<CountryJpaEntity>
    fun deleteById(id: Long)
    fun saveUpdate(entity: CountryJpaEntity): CountryJpaEntity

}
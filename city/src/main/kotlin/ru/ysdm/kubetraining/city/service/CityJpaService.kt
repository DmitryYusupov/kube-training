package ru.ysdm.kubetraining.city.service

import ru.ysdm.kubetraining.city.domain.CityJpaEntity
import java.util.*

interface CityJpaService {
    fun findAll(): MutableList<CityJpaEntity>
    fun findById(id: Long): Optional<CityJpaEntity>
    fun deleteById(id: Long)
    fun saveUpdate(entity: CityJpaEntity): CityJpaEntity
    fun findByCountryId(countryId: Long): MutableList<CityJpaEntity>
}
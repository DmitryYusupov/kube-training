package ru.ysdm.kubetraining.city.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.ysdm.kubetraining.city.domain.CityJpaEntity
import ru.ysdm.kubetraining.city.repo.CitySpringDataRepo
import ru.ysdm.kubetraining.city.service.CityJpaService
import java.util.*

@Service
@Transactional
class CityJpaServiceImpl(val citySpringDataRepo: CitySpringDataRepo) : CityJpaService{
    override fun findByCountryId(countryId: Long): MutableList<CityJpaEntity> = citySpringDataRepo.findByCountryId(countryId)

    override fun saveUpdate(entity: CityJpaEntity) = citySpringDataRepo.save(entity)

    override fun deleteById(id: Long) = citySpringDataRepo.deleteById(id)

    override fun findById(id: Long) = Optional.of(citySpringDataRepo.getOne(id))

    override fun findAll(): MutableList<CityJpaEntity> = citySpringDataRepo.findAll()
}
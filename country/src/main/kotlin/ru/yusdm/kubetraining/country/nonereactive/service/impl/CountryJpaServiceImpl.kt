package ru.yusdm.kubetraining.country.nonereactive.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.kubetraining.country.nonereactive.domain.CountryJpaEntity
import ru.yusdm.kubetraining.country.nonereactive.repo.CountrySpringDataRepo
import ru.yusdm.kubetraining.country.nonereactive.service.CountryJpaService
import java.util.*


@Service
@Transactional
class CountryJpaServiceImpl(val countrySpringDataRepo: CountrySpringDataRepo) : CountryJpaService {

    override fun saveUpdate(entity: CountryJpaEntity) = countrySpringDataRepo.save(entity)

    override fun deleteById(id: Long) = countrySpringDataRepo.deleteById(id)

    override fun findById(id: Long) = Optional.of(countrySpringDataRepo.getOne(id))

    override fun findAll(): MutableList<CountryJpaEntity> = countrySpringDataRepo.findAll()
}
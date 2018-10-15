package ru.yusdm.kubetraining.country

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import ru.yusdm.kubetraining.country.domain.CountryJpaEntity
import ru.yusdm.kubetraining.country.service.CountryJpaService

@Component
class CountryApplicationRunner(val countryJpaService: CountryJpaService) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        prepareTestCountries()
    }

    @Transactional
    fun prepareTestCountries() {
        val countries = mutableListOf(
                CountryJpaEntity().apply {
                    this.name = "Russia"
                    this.description = "Russia description"
                },

                CountryJpaEntity().apply {
                    this.name = "Belarus"
                    this.description = "Belarus description"
                }
        )

        countries.forEach {
            countryJpaService.saveUpdate(it)
        }
    }
}
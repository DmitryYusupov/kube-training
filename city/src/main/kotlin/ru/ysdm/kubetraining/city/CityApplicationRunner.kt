package ru.ysdm.kubetraining.city

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import ru.ysdm.kubetraining.city.nonereactive.domain.CityJpaEntity
import ru.ysdm.kubetraining.city.nonereactive.service.CityJpaService

@Component
class CityApplicationRunner(val cityJpaService: CityJpaService) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        prepareTestCities()
    }

    @Transactional
    fun prepareTestCities() {
        val cities = mutableListOf(
                //belongs to Russia
                CityJpaEntity().apply {
                    this.countryId = 1
                    this.name = "Moscow"
                    this.mainStreet = "Red square"
                    this.description = "This is the capital of Russia"
                },

                CityJpaEntity().apply {
                    this.countryId = 1
                    this.name = "Spb"
                    this.mainStreet = "Nevskiy prospekt"
                    this.description = "The second largest city in Russia"
                },

                //belongs to Belarus
                CityJpaEntity().apply {
                    this.countryId = 2
                    this.name = "Minsk"
                    this.mainStreet = "Lenin street"
                    this.description = "This is the capital of Belarus"
                },

                CityJpaEntity().apply {
                    this.countryId = 2
                    this.name = "Vitebsk"
                    this.mainStreet = "Vitebsk main street"
                    this.description = "One of the biggest cities in Belarus"
                }
        )

        cities.forEach {
            cityJpaService.saveUpdate(it)
        }
    }

}
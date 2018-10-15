package ru.ysdm.kubetraining.city.domain

import java.time.Clock
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class CityJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    var id: Long? = null

    @Column(name = "COUNTRY_ID")
    var countryId: Long? = null

    @Column(name = "NAME")
    var name: String? = null

    @Column(name = "MAIN_STREET")
    var mainStreet: String? = null

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @Column(name = "CREATION_DATE")
    var creationDate = LocalDateTime.now(Clock.systemUTC())

}



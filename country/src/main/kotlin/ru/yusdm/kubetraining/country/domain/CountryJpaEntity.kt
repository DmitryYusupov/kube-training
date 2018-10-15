package ru.yusdm.kubetraining.country.domain

import java.time.Clock
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class CountryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    var id: Long? = null

    @Column(name = "NAME")
    var name: String? = null

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @Column(name = "CREATION_DATE")
    var creationDate = LocalDateTime.now(Clock.systemUTC())
}
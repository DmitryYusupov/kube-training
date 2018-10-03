package ru.yusdm.kubetraining.common.business.dto

class CountryDTO{
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    val cities = mutableListOf<CityDTO>()
}

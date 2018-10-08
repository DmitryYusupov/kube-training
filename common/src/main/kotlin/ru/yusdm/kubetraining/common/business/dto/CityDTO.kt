package ru.yusdm.kubetraining.common.business.dto

import java.io.Serializable

class CityDTO : Serializable{
    var id: Long? = null
    var countryId: Long? = null
    var name: String? = null
    var mainStreet: String? = null
    var description: String? = null
}
package arquitectura.software.con_divi.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class LocationRespDto (
    val city: String?,
    val continent_code: String?,
    val continent_name: String?,
    val country_code: String?,
    val country_name: String?,
    val currencies: List<CurrencyDto>?,
    val ip: String?,
    val is_eu: Boolean?,
    val latitude: Double?,
    val location: LocationDetailsDto?,
    val longitude: Double?,
    val region_name: String?,
    val timezones: List<String>?,
    val type: String?
    ){
    constructor() : this(null, null, null, null, null, listOf(), null, false, 0.0, LocationDetailsDto(), 0.0, "", listOf(), null)

    @Override
    override fun toString(): String {
        return "LocationRespDto(city=$city, continent_code=$continent_code, continent_name=$continent_name, country_code=$country_code, country_name=$country_name, currencies=$currencies, ip=$ip, is_eu=$is_eu, latitude=$latitude, location=$location, longitude=$longitude, region_name=$region_name, timezones=$timezones, type=$type)"
    }
}
package arquitectura.software.con_divi.bl
import arquitectura.software.con_divi.dto.LocationRespDto
import org.springframework.beans.factory.annotation.Value

import org.springframework.stereotype.Service


@Service
class LocationBl (private val locationProvider: LocationProvider) {


    fun location(ip: String): LocationRespDto {
        return locationProvider.getLocation(ip)
    }


}
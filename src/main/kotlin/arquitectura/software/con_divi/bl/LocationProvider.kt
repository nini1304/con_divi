package arquitectura.software.con_divi.bl

import arquitectura.software.con_divi.dto.LocationRespDto

interface LocationProvider {
    fun getLocation(ip: String): LocationRespDto
}
package arquitectura.software.con_divi.dto

data class LocationReqDto (
    var ip: String?,
){
    constructor() : this(null)

    override fun toString(): String {
        return "LocationReqDto(ip='$ip')"
    }
}
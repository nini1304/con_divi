package arquitectura.software.con_divi.dto

data class LocationDetailsDto (
    val calling_codes: List<String>,
    val capital: String?,
    val flag: String?,
    val native_name: String?,
    val top_level_domains: List<String>
    ){
    constructor() : this(listOf(), null, null, null, listOf())

    @Override
    override fun toString(): String {
        return "LocationDetailsDto(calling_codes=$calling_codes, capital=$capital, flag=$flag, native_name=$native_name, top_level_domains=$top_level_domains)"
    }
}
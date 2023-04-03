package arquitectura.software.con_divi.dto

data class CurrencyDto (
    val code: String?,
    val name: String?,
    val symbol: String?

    ){
    constructor() : this(null, null, null)

    override fun toString(): String {
        return "CurrencyDto(code='$code', name='$name', symbol='$symbol')"
    }
}
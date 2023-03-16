package arquitectura.software.demo.dto

import java.math.BigDecimal
import java.math.BigInteger

data class InfoDto(
    //marca de tiempo de la taza de conversion
    var timestamp: BigInteger?,
    //taza de conversion entre dos monedas
    var rate: BigDecimal?
){
    constructor() : this(null,null)

    override fun toString(): String {
        return "InfoDto(timestamp=$timestamp, rate=$rate)"
    }
}

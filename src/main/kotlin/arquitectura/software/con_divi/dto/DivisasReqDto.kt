package arquitectura.software.demo.dto

import java.math.BigDecimal

data class DivisasReqDto(
    var from: String,
    var to: String,
    var amount: BigDecimal
)
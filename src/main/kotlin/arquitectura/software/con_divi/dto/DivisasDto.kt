package arquitectura.software.demo.dto

import java.math.BigDecimal

data class DivisasDto(
    var success: Boolean,
    var query: DivisasReqDto,
    var info: InfoDto,
    var date: String,
    var result: BigDecimal
)
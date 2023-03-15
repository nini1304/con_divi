package arquitectura.software.demo.dto

import java.math.BigDecimal

data class DivisasDto(
    var success: Boolean,
    var query: DivisasReqDto?,
    var info: InfoDto?,
    var date: String?,
    var result: BigDecimal?
){
    constructor() : this(false,null,null,null,null)
    constructor(query: DivisasReqDto?, result: BigDecimal?): this()

    override fun toString(): String {
        return "DivisasDto(success=$success, query=$query, info=$info, date='$date', result=$result)"
    }
}
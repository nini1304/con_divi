package arquitectura.software.demo.dto

data class DivisasRespDto<T>(
    var success: Boolean,
    var data: T,
    var message: String
)
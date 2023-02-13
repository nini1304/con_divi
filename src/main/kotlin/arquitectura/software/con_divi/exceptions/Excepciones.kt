package arquitectura.software.demo.exceptions

import arquitectura.software.demo.dto.DivisasRespDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerExceptions {

    @ExceptionHandler(IllegalArgumentException::class)
    fun zeroException(e: IllegalArgumentException): ResponseEntity<DivisasRespDto<Any>> {
        val responseDto = DivisasRespDto<Any>(false, null, e.message.toString())
        return ResponseEntity.badRequest().body(responseDto)
    }
}
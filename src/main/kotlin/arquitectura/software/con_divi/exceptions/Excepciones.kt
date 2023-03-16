package arquitectura.software.demo.exceptions

import arquitectura.software.demo.dto.DivisasRespDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class Excepciones {

    @ExceptionHandler(IllegalArgumentException::class)
    fun zeroException(e: IllegalArgumentException): ResponseEntity<Any> {
        val responseDto = DivisasRespDto<Any>(false,0, e.message.toString())
        return ResponseEntity.badRequest().body(responseDto)
    }



}
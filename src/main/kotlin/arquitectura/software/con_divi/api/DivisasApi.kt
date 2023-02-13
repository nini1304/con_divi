package arquitectura.software.con_divi.api
import arquitectura.software.con_divi.bl.DivisasBl

import arquitectura.software.demo.dto.DivisasRespDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.math.BigDecimal

@RestController
@RequestMapping("api/v1/diviapi")
class DivisasApi(private val divisasBl: DivisasBl) {

    @GetMapping("/convertion")
    fun obtain(@RequestParam from: String, @RequestParam to: String, @RequestParam amount: BigDecimal): ResponseEntity<DivisasRespDto<Any>> {
        val divisasDto = divisasBl.convert(from, to, amount)
        val divisasrespDto = DivisasRespDto<Any>(true, divisasDto, "success")
        return ResponseEntity.ok(divisasrespDto)
    }
}
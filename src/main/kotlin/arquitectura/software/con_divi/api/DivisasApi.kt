package arquitectura.software.con_divi.api
import arquitectura.software.con_divi.bl.DivisasBl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("api/v1/diviapi")
class DivisasApi(private val divisasBl: DivisasBl) {


    @GetMapping("/list") fun getListConvertions(@RequestParam page: Int, @RequestParam size: Int) : Any {
        val convertions = divisasBl.getListConvertions(page, size);
        return ResponseEntity.ok(convertions)
    }


    @GetMapping("/convertion")
    fun convert(@RequestParam from: String, @RequestParam to: String, @RequestParam amount: BigDecimal): ResponseEntity<Any> {
        val divisasDto = divisasBl.convert(from, to, amount)
        return ResponseEntity.ok(divisasDto)
    }
}
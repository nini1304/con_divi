package arquitectura.software.con_divi.api
import arquitectura.software.con_divi.bl.DivisasBl
import arquitectura.software.con_divi.bl.LocationBl
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

   // @GetMapping("/user")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
  //  fun user(): String {
     //   return "user"
   // }

   // @GetMapping("/admin")
   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   // fun admin(): String {
   //     return "admin"
   // }
    //siempre al manejar seguridad con cualquier libreria se tiene acceso a la clase principal
   // @GetMapping("/principal")
   // fun info(principal: Principal): String {
        //retornamostodo el principal para ver lo que se guardo en memoria
    //    return principal.toString()
    //}
}
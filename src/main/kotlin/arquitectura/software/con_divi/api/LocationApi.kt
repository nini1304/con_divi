package arquitectura.software.con_divi.api

import arquitectura.software.con_divi.bl.LocationBl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/locapi")
class LocationApi (private val locationBl: LocationBl){
    @GetMapping("/location/{ip}")
    fun location(@PathVariable ip: String): ResponseEntity<Any> {
        val locationRespDto = locationBl.location(ip)
        return ResponseEntity.ok(locationRespDto)
    }
}
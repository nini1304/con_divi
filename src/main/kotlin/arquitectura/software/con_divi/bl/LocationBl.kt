package arquitectura.software.con_divi.bl
import arquitectura.software.con_divi.dto.LocationRespDto
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class LocationBl {
    @Value("\${location.url}")
    private val url: String? = null

    @Value("\${location.api_key}")
    private val apiKey: String? = null



    fun location(ip:String): LocationRespDto {

        val client = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url("https://api.apilayer.com/ip_to_location/$ip")
            .addHeader("apikey", apiKey)
            .method("GET", null)
            .build()
        val response = client.newCall(request).execute()
        val result = response.body()!!.string()
        val mapper = ObjectMapper()
        val locationRespDto = mapper.readValue(result,LocationRespDto::class.java)
        return locationRespDto
    }
}
package arquitectura.software.con_divi.bl

import arquitectura.software.con_divi.dto.LocationRespDto
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request

class ApiLayerLocationProvider () : LocationProvider {

    override fun getLocation(ip: String): LocationRespDto {
        val client = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url("https://api.apilayer.com/ip_to_location/$ip")
            .addHeader("apikey","hDLkHHWZoNZ70m6BQ2014qh90v8qruVY")
            .method("GET", null)
            .build()
        val response = client.newCall(request).execute()
        val result = response.body()!!.string()
        val mapper = ObjectMapper()
        return mapper.readValue(result, LocationRespDto::class.java)
    }
}
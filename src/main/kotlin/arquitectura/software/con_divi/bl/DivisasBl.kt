package arquitectura.software.con_divi.bl
import arquitectura.software.demo.dto.DivisasDto
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.stereotype.Service
import java.io.IOException
import java.math.BigDecimal

@Service
class DivisasBl {

    fun convert(from: String, to: String, amount: BigDecimal): DivisasDto {
        if (amount <= BigDecimal.ZERO) {
            throw IllegalArgumentException("The change amount must be greater than 0 and not equal to 0")
        }

        val client = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url("https://api.apilayer.com/exchangerates_data/convert?from=$from&to=$to&amount=$amount")
            .addHeader("apikey", "bOv9VzwtvbtNuPhxLT3oZ5Xat8qE8ufB")
            .method("GET", null)
            .build()
        val response = client.newCall(request).execute()
        val result = response.body()!!.string()

        val mapper = ObjectMapper()
        val divisasDto = mapper.readValue(result, DivisasDto::class.java)
        return divisasDto
    }
}
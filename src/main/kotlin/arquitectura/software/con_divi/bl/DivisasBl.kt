package arquitectura.software.con_divi.bl
import arquitectura.software.con_divi.dao.DivisasDao

import arquitectura.software.con_divi.dao.Repository.DivisasRepository
import arquitectura.software.demo.dto.DivisasDto
import arquitectura.software.demo.dto.DivisasRespDto
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Service
import java.io.IOException
import java.math.BigDecimal
import java.util.*

@Service
class DivisasBl(private val divisasRepository: DivisasRepository) {
    companion object {
        private val objectMapper = ObjectMapper()
        private val LOGGER = LoggerFactory.getLogger(DivisasBl::class.java)
    }

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
        if(response.isSuccessful){
            LOGGER.info("La respuesta fue exitosa")

            val currencyDto = objectMapper.readValue(result, DivisasDto::class.java)
            val currency: DivisasDao = DivisasDao()
            currency.currencyFrom = from
            currency.currencyTo = to
            currency.amount = amount
            currency.result = currencyDto.result!!
            currency.date = Date()
            divisasRepository.save(currency)
            LOGGER.info("Conversion result: ${result}")
        }

        val mapper = ObjectMapper()
        val divisasDto = mapper.readValue(result, DivisasDto::class.java)
        return divisasDto
    }
}
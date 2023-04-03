package arquitectura.software.con_divi.bl
import arquitectura.software.con_divi.dao.DivisasDao
import arquitectura.software.con_divi.dao.Repository.DivisaRepository
import arquitectura.software.demo.dto.DivisasDto
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class DivisasBl  @Autowired constructor(private val divisaRepository: DivisaRepository) {

    companion object {
        val objectMapper = jacksonObjectMapper()
        val LOGGER: Logger = LoggerFactory.getLogger(LocationBl::class.java.name)
    }

    @Value("\${currency.url}")
    private val url: String? = null

    @Value("\${currency.api_key}")
    private val apiKey: String? = null


    fun getListConvertions(page: Int, size: Int): Any {

        val currencies = divisaRepository.findAll(PageRequest.of(page, size))
        return currencies
    }

    fun convert(from: String, to: String, amount: BigDecimal): DivisasDto {
        if (amount <= BigDecimal.ZERO) {
            throw IllegalArgumentException("The change amount must be greater than 0 and not equal to 0")
        }
        val client = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url("$url?from=$from&to=$to&amount=$amount")
            .addHeader("apikey", apiKey)
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
            divisaRepository.save(currency)
            LOGGER.info("Conversion result: ${result}")
        }

        val mapper = ObjectMapper()
        val divisasDto = mapper.readValue(result, DivisasDto::class.java)
        return divisasDto
    }

}
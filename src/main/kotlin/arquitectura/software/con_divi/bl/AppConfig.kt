package arquitectura.software.con_divi.bl

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun locationProvider(): LocationProvider {
        return ApiLayerLocationProvider()
    }
}
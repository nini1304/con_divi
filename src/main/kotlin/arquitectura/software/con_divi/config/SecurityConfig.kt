package arquitectura.software.con_divi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
    }
    //interfaz para crear un usuario
    @Bean
    fun users(): UserDetailsService {
        val user = User.builder()
            .username("user")
             //el noop encripta la contraseña
            .password("{noop}user")
            .roles("USER")
            .build()
        val admin = User.builder()
            .username("admin")
            .password("{noop}admin")
            .roles("USER","ADMIN")
            .build()
        //para registrar los usuarios en memoria
        return InMemoryUserDetailsManager(user, admin)
    }
}
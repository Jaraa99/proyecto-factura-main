package Config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.beans.Customizer


@Configuration
class SecurityConfig {

    @Autowired
    private val jwtFilter: JwtFilter? = null

    @Bean
    @Throws(Exception::class)
    open fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .csrf{csrf->csrf.disable()}
            .cors(Customizer.withDefaults())
            .sessionManagement{sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)}
            .authorizeHttpRequests{authRequest->
                authRequest
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().aunthenticated()
            }
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()


    }

    @Bean
    @Throws(java.lang.Exception::class)
    fun authenticationManager(configuration: AuthenticationConfiguration): AuthenticationManager? {
        return configuration.authenticationManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
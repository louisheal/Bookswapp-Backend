package ac.ic.drp19.backend.auth

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

private val AUTH_WHITELIST = arrayOf(
    "/login"
)

private val POST_WHITELIST = arrayOf(
    "/signup"
)

@EnableWebSecurity
class WebSecurityConfiguration(
    private val passwordEncoder: BCryptPasswordEncoder,
    private val userDetailsService: UserDetailsService
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers(*AUTH_WHITELIST).permitAll()
            .antMatchers(HttpMethod.POST, *POST_WHITELIST).permitAll()
            .anyRequest().authenticated()
            .and().addFilter(AuthenticationFilter(authenticationManager()))
            .addFilter(AuthorizationFilter(authenticationManager()))
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    override fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder)
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration(
            "/**",
            CorsConfiguration().applyPermitDefaultValues()
        )
        return source
    }
}

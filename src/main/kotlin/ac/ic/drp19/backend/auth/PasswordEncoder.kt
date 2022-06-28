package ac.ic.drp19.backend.auth

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
object PasswordEncoder {

    @Bean
    fun bCrypt(): BCryptPasswordEncoder = BCryptPasswordEncoder()
}

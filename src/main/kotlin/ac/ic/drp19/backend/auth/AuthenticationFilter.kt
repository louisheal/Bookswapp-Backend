package ac.ic.drp19.backend.auth

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.userdetails.User as UserCredentials

private const val timeoutMillis = 864_000_000_000

private data class UserLoginDto(
    var username: String = "",
    var password: String = ""
)

class AuthenticationFilter(
    authenticationManager: AuthenticationManager
) : UsernamePasswordAuthenticationFilter(authenticationManager) {

    init {
        setFilterProcessesUrl("/login")
    }

    override fun attemptAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse
    ): Authentication {
        try {
            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false)
            val creds = mapper.readValue(request.inputStream, UserLoginDto::class.java)
            return authenticationManager
                .authenticate(
                    UsernamePasswordAuthenticationToken(
                        creds.username,
                        creds.password,
                        emptyList()
                    )
                )
        } catch (e: IOException) {
            throw RuntimeException("Could not read request: $e")
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {
        val token = Jwts
            .builder()
            .setSubject((authResult.principal as UserCredentials).username)
            .setExpiration(Date(System.currentTimeMillis() + timeoutMillis))
            .signWith(SigningKey.get())
            .compact()
        response.addAuthorizationHeader(token)
    }
}

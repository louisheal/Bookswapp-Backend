package ac.ic.drp19.backend.auth

import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthorizationFilter(
    authenticationManager: AuthenticationManager
) : BasicAuthenticationFilter(authenticationManager) {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        val header: String? = request.getHeader(AUTHORIZATION)
        if (header == null || !isBearer(header)) {
            chain.doFilter(request, response)
            return
        }
        val authenticationToken = getAuthentication(header)
        SecurityContextHolder
            .getContext()
            .authentication = authenticationToken
        chain.doFilter(request, response)
    }

    private fun getAuthentication(
        authorizationToken: String
    ): UsernamePasswordAuthenticationToken? {
        val user: String? = Jwts
            .parserBuilder()
            .setSigningKey(SigningKey.get())
            .build()
            .parseClaimsJws(
                authorizationToken.replace(BEARER, "")
            )
            .body
            .subject
        if (user != null) {
            return UsernamePasswordAuthenticationToken(user, null, emptyList())
        }
        return null
    }
}

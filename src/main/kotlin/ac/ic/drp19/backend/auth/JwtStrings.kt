package ac.ic.drp19.backend.auth

import javax.servlet.http.HttpServletResponse

const val AUTHORIZATION = "Authorization"

const val BEARER = "Bearer"

fun isBearer(header: String) = header.startsWith(BEARER)

fun HttpServletResponse.addAuthorizationHeader(token: String) {
    this.addHeader(AUTHORIZATION, "$BEARER $token")
}

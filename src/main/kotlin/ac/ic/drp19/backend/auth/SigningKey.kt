package ac.ic.drp19.backend.auth

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import java.security.Key

object SigningKey {

    private val secret = Keys.secretKeyFor(SignatureAlgorithm.HS512)

    private fun getSigningKey(str: String): Key {
        val keyBytes = Decoders.BASE64.decode(str)
        return Keys.hmacShaKeyFor(keyBytes)
    }

    fun get(): Key = secret
}

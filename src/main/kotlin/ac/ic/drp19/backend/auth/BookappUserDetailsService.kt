package ac.ic.drp19.backend.auth

import ac.ic.drp19.backend.repository.UsersRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.User as SpringUser

@Service
class BookappUserDetailsService(
    private val usersRepository: UsersRepository
) : UserDetailsService {

    override fun loadUserByUsername(usernameOrEmail: String): UserDetails {
        val user = usersRepository
            .findByUsername(usernameOrEmail)
            ?: throw UsernameNotFoundException(
                "User not found with username: $usernameOrEmail"
            )
        return SpringUser(user.username, user.password, emptyList())
    }
}

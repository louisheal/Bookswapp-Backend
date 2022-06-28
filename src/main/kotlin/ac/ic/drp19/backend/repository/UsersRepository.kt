package ac.ic.drp19.backend.repository

import ac.ic.drp19.backend.model.User
import org.springframework.data.repository.CrudRepository

interface UsersRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?
    fun findByEmail(email: String): User?
    fun findByPhone(phone: String): User?

    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
    fun existsByPhone(phone: String): Boolean
}

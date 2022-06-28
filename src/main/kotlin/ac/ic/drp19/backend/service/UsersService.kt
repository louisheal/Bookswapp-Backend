package ac.ic.drp19.backend.service

import ac.ic.drp19.backend.model.Ownership
import ac.ic.drp19.backend.model.User
import ac.ic.drp19.backend.repository.UsersRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsersService(
    private val db: UsersRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    fun findUsers(username: String? = null): Iterable<User> = db.findAll()

    fun findUserById(userId: Long): User? = db.findByIdOrNull(userId)

    fun findUserOwns(userId: Long): List<Ownership>? = findUserById(userId)?.owns

    fun signUp(
        username: String,
        password: String,
        name: String,
        institution: String,
        department: String,
        email: String? = null,
        phone: String? = null
    ) {
        val user = User(
            username = username,
            password = passwordEncoder.encode(password),
            name = name,
            institution = institution,
            department = department,
            email = email,
            phone = phone
        )
        db.save(user)
    }
}

package ac.ic.drp19.bookappbackend.service

import ac.ic.drp19.bookappbackend.model.Book
import ac.ic.drp19.bookappbackend.model.User
import ac.ic.drp19.bookappbackend.repository.UsersRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UsersService(val db: UsersRepository) {

    fun findUsers(username: String? = null): List<User> = db.findUsers()

    fun findUserById(userId: Long): User? = db.findByIdOrNull(userId)

    fun postUser(user: User) {
        db.save(user)
    }
}

package ac.ic.drp19.bookappbackend.service

import ac.ic.drp19.bookappbackend.model.User
import ac.ic.drp19.bookappbackend.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class UsersService(val db: UsersRepository) {

    fun findUsers(username: String? = null): List<User> {
        if (username == null) {
            return db.findUsers()
        }
        return listOfNotNull(db.findByUsername(username))
    }

    fun postUser(user: User) {
        db.save(user)
    }
}

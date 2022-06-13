package ac.ic.drp19.backend.service

import ac.ic.drp19.backend.model.Book
import ac.ic.drp19.backend.model.User
import ac.ic.drp19.backend.repository.OwnershipRepository
import org.springframework.stereotype.Service

@Service
class OwnershipService(val db: OwnershipRepository) {

    fun findOwnersOfBook(bookId: Long): List<User> = db.findOwnersOfBook(bookId)

    fun findUserBooks(userId: Long): List<Book> = db.findUserBooks(userId)
}

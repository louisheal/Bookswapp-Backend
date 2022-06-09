package ac.ic.drp19.bookappbackend.service

import ac.ic.drp19.bookappbackend.model.User
import ac.ic.drp19.bookappbackend.repository.OwnershipRepository
import org.springframework.stereotype.Service

@Service
class OwnershipService(val db: OwnershipRepository) {

    fun findOwnersOfBook(bookId: Long): List<User> = db.findOwnersOfBook(bookId)
}

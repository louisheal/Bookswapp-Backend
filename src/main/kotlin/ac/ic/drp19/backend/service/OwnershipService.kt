package ac.ic.drp19.backend.service

import ac.ic.drp19.backend.model.Book
import ac.ic.drp19.backend.model.Ownership
import ac.ic.drp19.backend.model.User
import ac.ic.drp19.backend.repository.BookRepository
import ac.ic.drp19.backend.repository.OwnershipRepository
import ac.ic.drp19.backend.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class OwnershipService(
    val ownerDb: OwnershipRepository,
    val userDb: UsersRepository,
    val bookDb: BookRepository
) {

    fun findOwnersOfBook(bookId: Long): List<User> = ownerDb.findOwnersOfBook(bookId)

    fun findUserBooks(userId: Long): List<Book> = ownerDb.findUserBooks(userId)

    fun findOwnership(userId: Long, bookId: Long): Ownership? =
        ownerDb.findOwnership(userId, bookId)

    fun postOwnership(
        userId: Long,
        bookId: Long,
        totalCopies: Int,
        currentCopies: Int
    ) {
        if (findOwnership(userId, bookId) == null) {
            val userOptional = userDb.findById(userId)
            val bookOptional = bookDb.findById(bookId)
            userOptional.ifPresent { user ->
                bookOptional.ifPresent { book ->
                    val ownership = Ownership(
                        owner = user,
                        book = book,
                        totalCopies = totalCopies,
                        currentCopies = currentCopies
                    )
                    ownerDb.save(ownership)
                }
            }
        }
    }
}

package ac.ic.drp19.bookappbackend.repository

import ac.ic.drp19.bookappbackend.model.Ownership
import ac.ic.drp19.bookappbackend.model.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface OwnershipRepository : CrudRepository<Ownership, Long> {

    @Query("select o.owner as u from Ownership o where o.book.id = :book_id")
    fun findOwnersOfBook(@Param("book_id") bookId: Long): List<User>
}

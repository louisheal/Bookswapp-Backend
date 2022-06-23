package ac.ic.drp19.backend.repository

import ac.ic.drp19.backend.model.Book
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface BookRepository : CrudRepository<Book, Long> {

    @Query("select b " +
            "from Book b " +
            "where " +
            "b not in (select l.request.book from Loan l) " +
            "AND " +
            "b not in (select o.book from Ownership o where o.owner.id = :user_id)")
    fun findBooks(@Param("user_id") userId: Long): List<Book>

    @Query("select b from Book b where b.isbn = :isbn")
    fun findByIsbn(@Param("isbn") isbn: String): Book?
}

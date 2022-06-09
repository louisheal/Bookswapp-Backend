package ac.ic.drp19.bookappbackend.repository

import ac.ic.drp19.bookappbackend.model.Book
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {

    @Query("select b from Book b")
    fun findBooks(): List<Book>
}

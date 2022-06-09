package ac.ic.drp19.bookappbackend.service

import ac.ic.drp19.bookappbackend.model.Book
import ac.ic.drp19.bookappbackend.repository.BookRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookService(val db: BookRepository) {

    fun findBooks(): List<Book> = db.findBooks()

    fun findBookById(id: Long): Book? = db.findByIdOrNull(id)

    fun postBook(book: Book) {
        db.save(book)
    }
}
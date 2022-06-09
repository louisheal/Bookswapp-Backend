package ac.ic.drp19.bookappbackend.service

import ac.ic.drp19.bookappbackend.model.Book
import ac.ic.drp19.bookappbackend.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val db: BookRepository) {

    fun findBooks(): List<Book> = db.findBooks()

    fun postBook(book: Book) {
        db.save(book)
    }
}
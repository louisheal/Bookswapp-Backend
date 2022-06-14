package ac.ic.drp19.backend.service

import ac.ic.drp19.backend.model.Book
import ac.ic.drp19.backend.repository.BookRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookService(
    val db: BookRepository,
    val olService: OpenLibraryService
) {

    fun findBooks(): List<Book> = db.findBooks()

    fun findBookById(id: Long): Book? = db.findByIdOrNull(id)

    fun findBookByIsbn(isbn: String): Book? = db.findByIsbn(isbn)

    fun postBook(isbn: String) {
        if (findBookByIsbn(isbn) == null) {
            olService
                .retrieveBookObject(isbn)
                .map {
                    Book(
                        isbn = isbn,
                        title = it.title,
                        published = it.publishDate
                    )
                }
                .subscribe {
                    db.save(it)
                }
        }
    }
}

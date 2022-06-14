package ac.ic.drp19.backend.resource

import ac.ic.drp19.backend.model.Book
import ac.ic.drp19.backend.service.BookService
import ac.ic.drp19.backend.util.removeQuotes
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BooksResource(
    val bookService: BookService
) {

    @GetMapping("/books")
    fun books(): List<Book> = bookService.findBooks()

    @GetMapping("/books/{id}")
    fun bookId(
        @PathVariable(name = "id") bookId: Long
    ): Book? =
        bookService.findBookById(bookId)

    @PostMapping("/books")
    fun postBook(@RequestBody isbn: String) {
        bookService.postBook(removeQuotes(isbn))
    }
}

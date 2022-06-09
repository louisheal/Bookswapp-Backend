package ac.ic.drp19.bookappbackend.resource

import ac.ic.drp19.bookappbackend.model.Book
import ac.ic.drp19.bookappbackend.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookResource(val service: BookService) {
    @GetMapping("/books")
    fun booksIndex(): List<Book> = service.findBooks()

    @PostMapping("/books")
    fun postBook(@RequestBody book: Book) {
        service.postBook(book)
    }
}

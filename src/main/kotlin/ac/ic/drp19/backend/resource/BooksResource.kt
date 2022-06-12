package ac.ic.drp19.backend.resource

import ac.ic.drp19.backend.model.Book
import ac.ic.drp19.backend.model.User
import ac.ic.drp19.backend.service.BookService
import ac.ic.drp19.backend.service.OwnershipService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BooksResource(
    val bookService: BookService,
    val ownershipService: OwnershipService
) {

    @GetMapping("/books")
    fun books(): List<Book> = bookService.findBooks()

    @GetMapping("/books/{id}")
    fun bookId(
        @PathVariable(name = "id") bookId: Long
    ): Book? =
        bookService.findBookById(bookId)

    @GetMapping("/books/{id}/owners")
    fun bookOwners(
        @PathVariable(name = "id") bookId: Long
    ): List<User> =
        ownershipService.findOwnersOfBook(bookId)

    @PostMapping("/books")
    fun postBook(@RequestBody book: Book) {
        bookService.postBook(book)
    }
}

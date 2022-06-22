package ac.ic.drp19.backend.resource

import ac.ic.drp19.backend.model.Book
import ac.ic.drp19.backend.model.User
import ac.ic.drp19.backend.service.BookService
import ac.ic.drp19.backend.service.OwnershipService
import ac.ic.drp19.backend.util.removeQuotes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class BooksResource(
    val bookService: BookService,
    val ownershipService: OwnershipService
) {

    @GetMapping("/books/all_but_user/{id}")
    fun books(
        @PathVariable(name = "id") userId: Long
    ): List<Book> = bookService.findBooks(userId)

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
    fun postBook(@RequestBody isbn: String): ResponseEntity<Any?> {
        return try {
            val book = bookService.postBookByIsbn(removeQuotes(isbn))
            ResponseEntity(book, HttpStatus.OK)
        } catch (e: ResponseStatusException) {
            ResponseEntity(e.reason, e.status)
        }
    }
}

package ac.ic.drp19.bookappbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BookappBackendApplication

@RestController
class IndexController {
    @GetMapping("/")
    fun index(): String {
        return "Book app in development..."
    }
}

fun main(args: Array<String>) {
    runApplication<BookappBackendApplication>(*args)
}

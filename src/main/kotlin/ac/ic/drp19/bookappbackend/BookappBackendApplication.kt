package ac.ic.drp19.bookappbackend // ktlint-disable filename

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BookappBackendApplication : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(BookappBackendApplication::class.java)
    }

    fun main(args: Array<String>) {
        runApplication<BookappBackendApplication>(*args)
    }
}

@RestController
class NullResource {
    @GetMapping
    fun index() = "Book app in development..."
}
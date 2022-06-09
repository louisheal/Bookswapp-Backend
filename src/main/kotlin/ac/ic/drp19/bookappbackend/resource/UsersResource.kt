package ac.ic.drp19.bookappbackend.resource

import ac.ic.drp19.bookappbackend.model.Ownership
import ac.ic.drp19.bookappbackend.model.User
import ac.ic.drp19.bookappbackend.service.UsersService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersResource(
    val service: UsersService
) {

    @GetMapping("/users")
    fun users(): List<User> = service.findUsers()

    @GetMapping("/users/{user_id}")
    fun user(
        @PathVariable("user_id") userId: Long
    ): User? =
        service.findUserById(userId)

    @GetMapping("/users/{user_id}/owns")
    fun userOwns(
        @PathVariable("user_id") userId: Long
    ): List<Ownership>? =
        user(userId)?.owns

    @PostMapping("/users")
    fun postUser(@RequestBody user: User) {
        service.postUser(user)
    }
}

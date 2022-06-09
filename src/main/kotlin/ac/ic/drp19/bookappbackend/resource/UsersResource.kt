package ac.ic.drp19.bookappbackend.resource

import ac.ic.drp19.bookappbackend.model.User
import ac.ic.drp19.bookappbackend.service.UsersService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersResource(val service: UsersService) {

    @GetMapping("/users")
    fun users(
        @RequestParam("username", required = false) username: String?
    ): List<User> =
        service.findUsers(username)

    @PostMapping("/users")
    fun postUser(@RequestBody user: User) {
        service.postUser(user)
    }
}

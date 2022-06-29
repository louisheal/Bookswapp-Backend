package ac.ic.drp19.backend.resource

import ac.ic.drp19.backend.model.Book
import ac.ic.drp19.backend.model.Ownership
import ac.ic.drp19.backend.model.User
import ac.ic.drp19.backend.service.OwnershipService
import ac.ic.drp19.backend.service.UsersService
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersResource(
    private val userService: UsersService,
    private val ownerService: OwnershipService
) {

    @PostMapping("/signup")
    fun signUp(@RequestBody userDto: UserDto) {
        userDto.apply {
            userService.signUp(username, password, name, institution, department, email, phone)
        }
    }

    @GetMapping("/users/current")
    fun currentUser(auth: Authentication): User =
        userService.getLoggedInUser()

    @GetMapping("/users")
    fun users(): Iterable<User> = userService.findUsers()

    @GetMapping("/users/{user_id}")
    fun user(
        @PathVariable("user_id") userId: Long
    ): User? =
        userService.findUserById(userId)

    @GetMapping("/users/{user_id}/owns")
    fun userOwns(
        @PathVariable("user_id") userId: Long
    ): List<Ownership>? =
        userService.findUserOwns(userId)

    @GetMapping("/users/{user_id}/books")
    fun userBooks(
        @PathVariable("user_id") userId: Long
    ): List<Book>? =
        ownerService.findUserBooks(userId)

    @PostMapping("/users/{user_id}/owns")
    fun postOwnership(
        @PathVariable("user_id") userId: Long,
        @RequestBody owns: OwnershipDto
    ) {
        owns.apply {
            ownerService.postOwnership(userId, bookId, totalCopies, currentCopies)
        }
    }
}

data class UserDto(
    val username: String,
    val password: String,
    val name: String,
    val institution: String,
    val department: String,
    val email: String? = null,
    val phone: String? = null
)

data class OwnershipDto(
    val bookId: Long,
    val totalCopies: Int,
    val currentCopies: Int
)

package net.devgrr.myfirstkotlin.web

import net.devgrr.myfirstkotlin.model.user.UserRequest
import net.devgrr.myfirstkotlin.model.user.UserResponse
import net.devgrr.myfirstkotlin.service.UserService
import net.devgrr.myfirstkotlin.service.UserSupportService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = ["*"])
class UserController(
    private val userService: UserService,
    private val userSupportService: UserSupportService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: UserRequest): UserResponse = userService.create(request)

    @GetMapping
    fun findAll() = userService.findAll()

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): UserResponse = userService.find(id)

    @GetMapping("/name/{name}")
    fun findUsersByName(@PathVariable name: String): List<UserResponse> = userService.findUsersByName(name)

    @PutMapping("/{id}")
    fun modify(@PathVariable id: Long, request: UserRequest): UserResponse = userService.modify(id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = userService.delete(id)

    @GetMapping("/find-all")
    fun findAllUsers() = userSupportService.findAllUsers()

    @GetMapping("/find/{id}")
    fun findUserById(@PathVariable id: Long) = userSupportService.findUserById(id)
}
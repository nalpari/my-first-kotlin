package net.devgrr.myfirstkotlin.service

import net.devgrr.myfirstkotlin.model.user.UserRequest
import net.devgrr.myfirstkotlin.model.user.UserRequest2
import net.devgrr.myfirstkotlin.model.user.UserResponse
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {

    @Autowired
    private lateinit var userService: UserService

    @Test
    fun find() {
        val user: UserResponse = userService.find(2L)

        assertEquals("user2", user.username)
    }

    @Test
    fun findUsersByName() {
        val users: List<UserResponse> = userService.findUsersByName("user1")

        assertEquals("user1", users.get(0).username)
    }

    @Test
    fun create() {
        val userRequest = UserRequest(
            username = "user4",
            email = "user4@user4.com",
            password = "user4",
            address = "서울시 강동구",
        )

        val user = userService.create(userRequest)

        assertEquals("user4", user.username)
    }

    @Test
    fun create2() {
        val userRequest = UserRequest2(
            username = "user5",
            email = "user5@user5.com",
            password = "user5",
            address = "서울시 강동구",
            hobbies = listOf("hobby1", "hobby2", "hobby3"),
        )

        val user = userService.create2(userRequest)
    }
}
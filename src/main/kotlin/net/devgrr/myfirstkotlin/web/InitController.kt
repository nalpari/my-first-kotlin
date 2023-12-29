package net.devgrr.myfirstkotlin.web

import jakarta.annotation.PostConstruct
import net.devgrr.myfirstkotlin.model.user.HobbyRequest
import net.devgrr.myfirstkotlin.model.user.UserRequest
import net.devgrr.myfirstkotlin.service.HobbyService
import net.devgrr.myfirstkotlin.service.UserService
import org.springframework.web.bind.annotation.RestController

@RestController
class InitController(
    private val userService: UserService,
    private val hobbyService: HobbyService,
) {

    @PostConstruct
    fun init() {
        userService.create(UserRequest("user1", "user1@user1.com", "qwer1234"))
        userService.create(UserRequest("user2", "user2@user2.com", "qwer1234"))
        userService.create(UserRequest("user3", "user3@user3.com", "qwer1234"))

        hobbyService.create(1, HobbyRequest("잠자기"))
        hobbyService.create(1, HobbyRequest("먹기"))
        hobbyService.create(1, HobbyRequest("놀기"))
        hobbyService.create(1, HobbyRequest("숨쉬기"))

        hobbyService.create(2, HobbyRequest("게임하기"))
        hobbyService.create(2, HobbyRequest("코딩하기"))
        hobbyService.create(2, HobbyRequest("자전거"))

        hobbyService.create(3, HobbyRequest("소개팅"))
        hobbyService.create(3, HobbyRequest("술마시기"))
    }
}
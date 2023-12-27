package net.devgrr.myfirstkotlin.web

import net.devgrr.myfirstkotlin.model.user.HobbyRequest
import net.devgrr.myfirstkotlin.model.user.HobbyResponse
import net.devgrr.myfirstkotlin.service.HobbyService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/hobby")
class HobbyController(
    private val hobbyService: HobbyService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(userId: Long, hobbyRequest: HobbyRequest): HobbyResponse {
        return hobbyService.create(userId, hobbyRequest)
    }
}
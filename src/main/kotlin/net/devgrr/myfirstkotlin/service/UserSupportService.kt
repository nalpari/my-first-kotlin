package net.devgrr.myfirstkotlin.service

import net.devgrr.myfirstkotlin.domain.user.repository.UserSupport
import net.devgrr.myfirstkotlin.domain.user.repository.UserSupportImpl
import net.devgrr.myfirstkotlin.model.user.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserSupportService(
    private val userSupport: UserSupportImpl,
) {
    fun findAllUsers(): List<UserResponse> {
        return userSupport.findAllUsers()
            .map { UserResponse(it) }
    }

    fun findUserById(id: Long): UserResponse {
        val user = userSupport.findUserById(id) ?: throw Exception("User not found")
        return UserResponse(user)
    }
}
package net.devgrr.myfirstkotlin.service

import net.devgrr.myfirstkotlin.domain.user.entity.User
import net.devgrr.myfirstkotlin.domain.user.repository.UserRepository
import net.devgrr.myfirstkotlin.model.user.UserRequest
import net.devgrr.myfirstkotlin.model.user.UserResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService (
    private val userRepository: UserRepository,
){
    @Transactional
    fun create(userRequest: UserRequest): UserResponse {
        val user = User(
            username = userRequest.username,
            email = userRequest.email,
            password = userRequest.password,
            address = userRequest.address,
        )
        return UserResponse(userRepository.save(user))
    }

    fun findAll(): List<UserResponse> {
        return userRepository.findAll()
            .map { UserResponse(it) }
    }

    fun find(id: Long): UserResponse {
        val user = userRepository.findByIdOrNull(id) ?: throw Exception("User not found")
        return UserResponse(user)
    }

    fun findUsersByName(name: String): List<UserResponse> {
        return userRepository.findUsersByName(name)
            .map { UserResponse(it) }
    }

    @Transactional
    fun modify(id: Long, userRequest: UserRequest): UserResponse {
        val user = userRepository.findByIdOrNull(id) ?: throw Exception("User not found")
        with(user) {
            this.username = userRequest.username
            this.email = userRequest.email
            this.address = userRequest.address

//            UserResponse(userRepository.save(this))
            userRepository.save(this)
        }

        val updatedUser = userRepository.findByIdOrNull(id) ?: throw Exception("User not found")
        return UserResponse(updatedUser)
    }

    @Transactional
    fun delete(id: Long) {
        userRepository.deleteById(id)
    }
}


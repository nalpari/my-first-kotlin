package net.devgrr.myfirstkotlin.service

import net.devgrr.myfirstkotlin.domain.user.entity.Hobby
import net.devgrr.myfirstkotlin.domain.user.repository.HobbyRepository
import net.devgrr.myfirstkotlin.domain.user.repository.UserRepository
import net.devgrr.myfirstkotlin.model.user.HobbyRequest
import net.devgrr.myfirstkotlin.model.user.HobbyResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class HobbyService(
    private val userRepository: UserRepository,
    private val hobbyRepository: HobbyRepository
) {
    @Transactional
    fun create(userId: Long, hobbyRequest: HobbyRequest): HobbyResponse {
        val user = userRepository.findByIdOrNull(userId) ?: throw Exception("User not found")
        val hobby = Hobby(
            name = hobbyRequest.name,
            user = user,
        )

        user.hobbies.add(hobby)
        return HobbyResponse(hobbyRepository.save(hobby))
    }
}
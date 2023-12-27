package net.devgrr.myfirstkotlin.model.user

import com.fasterxml.jackson.annotation.JsonFormat
import net.devgrr.myfirstkotlin.domain.user.entity.Hobby
import net.devgrr.myfirstkotlin.domain.user.entity.User

data class UserRequest(
    val username: String,
    val email: String,
    val password: String,
)

data class UserResponse(
    val id: Long,
    val username: String,
    val email: String,
    val hobbies: List<HobbyResponse>,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: String,
) {
    companion object {
        operator fun invoke(user: User) = with(user) {
            UserResponse(
                id = id!!,
                username = username,
                email = email,
                hobbies = hobbies.sortedByDescending(Hobby::id).map(HobbyResponse::invoke),
                createdAt = createdAt.toString(),
                updatedAt = updatedAt.toString(),
            )
        }
    }
}
package net.devgrr.myfirstkotlin.model.user

import net.devgrr.myfirstkotlin.domain.user.entity.Hobby

data class HobbyRequest(
    val name: String,
)

data class HobbyResponse (
    val id: Long,
    val name: String,
    val userId: Long,
    val createdAt: String,
    val updatedAt: String,
) {
    companion object {
        operator fun invoke(hobby: Hobby) = with(hobby) {
            HobbyResponse(
                id = id!!,
                name = name,
                userId = user.id!!,
                createdAt = createdAt.toString(),
                updatedAt = updatedAt.toString(),
            )
        }
    }
}
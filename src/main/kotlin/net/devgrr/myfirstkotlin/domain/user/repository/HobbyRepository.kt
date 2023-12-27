package net.devgrr.myfirstkotlin.domain.user.repository

import net.devgrr.myfirstkotlin.domain.user.entity.Hobby
import org.springframework.data.repository.CrudRepository

interface HobbyRepository: CrudRepository<Hobby, Long> {
}
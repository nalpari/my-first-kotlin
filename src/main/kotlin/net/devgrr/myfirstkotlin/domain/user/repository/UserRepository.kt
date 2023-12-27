package net.devgrr.myfirstkotlin.domain.user.repository

import net.devgrr.myfirstkotlin.domain.user.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>, UserSupport {
}
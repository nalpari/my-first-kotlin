package net.devgrr.myfirstkotlin.domain.user.repository

import net.devgrr.myfirstkotlin.domain.user.entity.User

interface UserSupport {
    fun findUsersByName(userName: String): List<User>
    fun findAllUsers(): List<User>
    fun findUserById(id: Long): User?
}
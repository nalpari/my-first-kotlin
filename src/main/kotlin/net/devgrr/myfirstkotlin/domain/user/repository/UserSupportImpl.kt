package net.devgrr.myfirstkotlin.domain.user.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import net.devgrr.myfirstkotlin.domain.user.entity.QUser
import net.devgrr.myfirstkotlin.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class UserSupportImpl(
    private val queryFactory: JPAQueryFactory
): UserSupport {
    override fun findUsersByName(userName: String): List<User> {
        return queryFactory
            .selectFrom(QUser.user)
            .where(QUser.user.username.eq(userName))
            .fetch()
    }

    override  fun findAllUsers(): List<User> {
        val user = QUser.user
        return queryFactory
            .selectFrom(user)
            .leftJoin(user.hobbies).fetchJoin()
            .fetch()
    }

    override fun findUserById(id: Long): User? {
        val user = QUser.user
        return queryFactory
            .selectFrom(user)
            .leftJoin(user.hobbies).fetchJoin()
            .where(user.id.eq(id))
            .fetchOne()
    }
}
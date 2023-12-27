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
}
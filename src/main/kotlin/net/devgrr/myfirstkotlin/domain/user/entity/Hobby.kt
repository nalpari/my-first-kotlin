package net.devgrr.myfirstkotlin.domain.user.entity

import jakarta.persistence.*
import net.devgrr.myfirstkotlin.domain.BaseEntity

@Entity
@Table(name = "hobbies")
class Hobby (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val name: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
) : BaseEntity()
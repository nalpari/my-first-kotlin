package net.devgrr.myfirstkotlin.domain.user.entity

import jakarta.persistence.*
import net.devgrr.myfirstkotlin.domain.BaseEntity

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var email: String = "",

    @Column
    val password: String = "",

    @Column
    var username: String = "",

    @OneToMany(fetch = FetchType.EAGER)
    val hobbies : MutableList<Hobby> = mutableListOf(),

) : BaseEntity()
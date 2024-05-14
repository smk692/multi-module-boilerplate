package kr.co.kotlin.infrastructure.rdb.user

import kr.co.kotlin.domain.user.domain.User
import kr.co.kotlin.infrastructure.rdb.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
internal class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "username")
    val username: String,

    @Column(name = "email")
    val email: String
) : BaseEntity() {
    companion object {
        fun fromDomain(domain: User) : UserEntity {
            return UserEntity(
                id = domain.id,
                username = domain.username,
                email = domain.email
            )
        }
    }

    fun toDomain(): User {
        return User(
            id = id,
            username = username,
            email = email
        )
    }
}

package kr.co.kotlin.infrastructure.rdb.user

import kr.co.kotlin.domain.user.domain.User
import kr.co.kotlin.infrastructure.rdb.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = "users")
@DynamicUpdate
class UserEntity(
    @Column(name = "username")
    var username: String,

    @Column(name = "email")
    var email: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
) : BaseEntity() {
    companion object {
        fun fromDomain(domain: User) : UserEntity {
            return UserEntity(
                id = domain.id,
                username = domain.userName,
                email = domain.email
            )
        }
    }

    fun toDomain(): User {
        return User(
            id = id,
            userName = username,
            email = email
        )
    }

    fun updateUserName(userName: String) {
        this.username = username
    }
}

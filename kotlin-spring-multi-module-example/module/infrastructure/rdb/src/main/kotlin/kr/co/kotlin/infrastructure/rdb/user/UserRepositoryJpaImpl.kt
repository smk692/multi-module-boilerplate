package kr.co.kotlin.infrastructure.rdb.user

import kr.co.kotlin.domain.user.domain.User
import kr.co.kotlin.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
internal class UserRepositoryJpaImpl(
    private val userJpaRepository: UserJpaRepository) : UserRepository {
    override fun findByIdOrNull(id: Long): User? {
        return userJpaRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun create(user: User) {
        userJpaRepository.save(UserEntity.fromDomain(user))
    }
}

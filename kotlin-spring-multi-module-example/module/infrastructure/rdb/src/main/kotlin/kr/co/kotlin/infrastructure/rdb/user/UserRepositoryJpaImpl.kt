package kr.co.kotlin.infrastructure.rdb.user

import com.querydsl.jpa.impl.JPAQueryFactory
import kr.co.kotlin.domain.user.domain.User
import kr.co.kotlin.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
internal class UserRepositoryJpaImpl(
    private val userJpaRepository: UserJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory,
    ) : UserRepository {
    override fun findByIdOrNull(id: Long): User? {
        return userJpaRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun findByUserName(userName: String): User? {
        return jpaQueryFactory.select(QUserEntity.userEntity)
            .from(QUserEntity.userEntity)
            .where(QUserEntity.userEntity.username.eq(userName))
            .fetchOne()
            ?.toDomain()
    }

    override fun create(user: User) {
        userJpaRepository.save(UserEntity.fromDomain(user))
    }

    override fun update(userDomain: User) {
        userJpaRepository.findByIdOrNull(userDomain.id)
            ?.let { entity ->
                entity.updateUserName(userDomain.userName)
                userJpaRepository.save(entity)
            }
            ?: throw IllegalArgumentException("User not found")
    }

    override fun update2(user: User) {
        userJpaRepository.save(UserEntity.fromDomain(user))
    }

    override fun update3(userDomain: User) {
        val entity = userJpaRepository.findByIdOrNull(userDomain.id) ?: throw IllegalArgumentException("User not found")
        entity.updateUserName(userDomain.userName)
    }

    override fun update4(userDomain: User) {
        jpaQueryFactory.update(QUserEntity.userEntity)
            .set(QUserEntity.userEntity.username, userDomain.userName)
            .where(QUserEntity.userEntity.id.eq(userDomain.id))
            .execute()
            .let {
                if (it == 0L) throw IllegalArgumentException("User not found")
            }
    }
}

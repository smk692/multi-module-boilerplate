package kr.co.kotlin.infrastructure.rdb.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["kr.co.kotlin.infrastructure.rdb"])
@EnableJpaRepositories(basePackages = ["kr.co.kotlin.infrastructure.rdb"])
internal class MainJpaConfig

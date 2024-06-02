package com.son.module.usecase.core.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.son.module.usecase"], lazyInit = true)
class UseCaseConfig

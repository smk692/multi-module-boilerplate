package kr.co.kotlin.boilerplate.support.client

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["kr.co.kotlin.boilerplate.support.client"])
@Configuration
internal class ExampleApiConfig

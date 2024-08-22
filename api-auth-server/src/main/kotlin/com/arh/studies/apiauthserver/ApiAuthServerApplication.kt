package com.arh.studies.apiauthserver

import com.arh.studies.apiauthserver.configuration.RsaKeyProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(RsaKeyProperties::class)
@SpringBootApplication
class ApiGatewayApplication

fun main(args: Array<String>) {
  runApplication<ApiGatewayApplication>(*args)
}

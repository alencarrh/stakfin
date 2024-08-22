package com.arh.studies.apiauthserver.controller

import com.arh.studies.apiauthserver.service.TokenService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class AuthController(val tokenService: TokenService) {

  private val logger = KotlinLogging.logger {}

  @PostMapping("token")
  fun token(authentication: Authentication): String {
    logger.info { "Generating token for ${authentication.name}" }

    return tokenService.generateToken(authentication)
  }


}
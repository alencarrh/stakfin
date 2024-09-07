package com.arh.stakfin.authserver.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController() {

  private val logger = KotlinLogging.logger {}

  @GetMapping("/hello")
  fun startListener(): String {
    logger.info { "Hello User!" }

    return "Hello User!"
  }
}

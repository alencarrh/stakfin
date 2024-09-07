package com.arh.stakfin.authserver.controller

import com.arh.studies.apiauthserver.persistence.entity.Users
import com.arh.studies.apiauthserver.persistence.repository.UsersRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/admin")
class AdminController(private val usersRepository: UsersRepository) {

  private val logger = KotlinLogging.logger {}

  @GetMapping("/hello")
  fun startListener(): String {
    logger.info { "Hello Admin!" }

    return "Hello Admin!"
  }

  @GetMapping("/users")
  fun getUsers(): List<Users> {
    logger.info { "Getting users" }

    return usersRepository.findAll().toList()
  }
}

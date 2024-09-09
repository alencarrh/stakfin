package com.arh.stakfin.core.web.controller

import com.arh.stakfin.core.web.request.CadastrarRendaVariavelRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/ativos/rendavariavel")
class RendaVariavelController() {

  private val logger = KotlinLogging.logger {}

  @PostMapping
  fun cadastrarRendaVariavel(@Valid @RequestBody request: CadastrarRendaVariavelRequest) {
    logger.info { "criar renda variavel $request" }
  }

}

package com.arh.stakfin.core.web.controller

import com.arh.stakfin.core.web.request.RendaFixaTransacaoRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/ativos/rendafixa")
class RendaFixaController() {

  private val logger = KotlinLogging.logger {}

  @PostMapping
  fun cadastrarRendaFixa(@Valid @RequestBody request: RendaFixaTransacaoRequest) {
    logger.info { "criar renda fixa $request" }
  }

}

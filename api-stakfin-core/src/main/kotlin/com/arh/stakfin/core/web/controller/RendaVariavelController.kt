package com.arh.stakfin.core.web.controller

import com.arh.stakfin.core.service.rendavariavel.CadastrarTransacaoRendaVariavelService
import com.arh.stakfin.core.web.request.TransacaoRendaVariavelRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/rendavariavel")
class RendaVariavelController(private val cadastrarTransacaoRendaVariavelService: CadastrarTransacaoRendaVariavelService) {

  private val logger = KotlinLogging.logger {}

  @PostMapping
  fun transaction(@Valid @RequestBody request: TransacaoRendaVariavelRequest) {
    cadastrarTransacaoRendaVariavelService.registrar(request)
    logger.info { "criar renda variavel $request" }
  }

}

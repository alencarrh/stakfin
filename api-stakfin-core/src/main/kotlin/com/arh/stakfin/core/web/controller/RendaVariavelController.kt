package com.arh.stakfin.core.web.controller

import com.arh.stakfin.core.model.RendaVariavelAtivo
import com.arh.stakfin.core.service.rendavariavel.CadastrarTransacaoService
import com.arh.stakfin.core.web.request.CadastrarTransacaoRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/transacao/rendavariavel")
class RendaVariavelController(private val cadastrarTransacaoService: CadastrarTransacaoService) {
  private val logger = KotlinLogging.logger {}

  @PostMapping
  fun cadastrar(@Valid @RequestBody request: CadastrarTransacaoRequest): RendaVariavelAtivo? {
    logger.info { "criar renda fixa $request" }
    return cadastrarTransacaoService.cadastrar(request)
  }

  //  @GetMapping("/{id}")
  //  fun getById(@PathVariable("id") id: Long): RendaFixaAtivo {
  //    logger.info { "criar renda fixa $id" }
  //    return cadastrarRendaVariavelService.findById(id)
  //  }
}

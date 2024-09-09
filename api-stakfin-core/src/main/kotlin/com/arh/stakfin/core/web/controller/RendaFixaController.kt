package com.arh.stakfin.core.web.controller

import com.arh.stakfin.core.model.rendafixa.RendaFixaAtivo
import com.arh.stakfin.core.service.CadastrarRendaFixaService
import com.arh.stakfin.core.service.RendaFixaService
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/ativos/rendafixa")
class RendaFixaController(
    private val rendaFixaService: RendaFixaService,
    private val cadastrarRendaFixaService: CadastrarRendaFixaService
) {

  private val logger = KotlinLogging.logger {}

  @PostMapping
  fun cadastrarRendaFixa(@Valid @RequestBody request: CadastrarRendaFixaRequest): RendaFixaAtivo {
    logger.info { "criar renda fixa $request" }
    return cadastrarRendaFixaService.cadastrar(request)
  }

  @GetMapping("/{id}")
  fun cadastrarRendaFixa(@PathVariable("id") id: Long): RendaFixaAtivo {
    logger.info { "criar renda fixa $id" }
    return rendaFixaService.findById(id)
  }
}

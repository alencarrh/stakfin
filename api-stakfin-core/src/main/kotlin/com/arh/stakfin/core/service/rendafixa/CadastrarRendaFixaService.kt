package com.arh.stakfin.core.service.rendafixa

import com.arh.stakfin.core.mapper.RendaFixaMapper
import com.arh.stakfin.core.model.RendaFixaAtivo
import com.arh.stakfin.core.persistence.repository.RendaFixaAtivoRepository
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CadastrarRendaFixaService(
  private val rendaFixaAtivoRepository: RendaFixaAtivoRepository,
  private val rendaFixaMapper: RendaFixaMapper
) {

  private val logger = KotlinLogging.logger {}

  fun cadastrar(request: CadastrarRendaFixaRequest): RendaFixaAtivo {

    logger.info { "Cadastrando renda fixa: $request" }

    val rendaFixa = rendaFixaMapper.toModel(request)
    val entity = rendaFixaMapper.toNewEntity(rendaFixa)
    val rendaFixaSaved = rendaFixaAtivoRepository.save(entity)

    return rendaFixaMapper.toModel(rendaFixaSaved)
  }
}

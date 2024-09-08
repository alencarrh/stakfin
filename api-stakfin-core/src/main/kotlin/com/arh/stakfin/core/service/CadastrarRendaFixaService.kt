package com.arh.stakfin.core.service

import com.arh.stakfin.core.mapper.RendaFixaMapper
import com.arh.stakfin.core.persistence.rendafixa.repository.RendaFixaRepository
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
@Component
class CadastrarRendaFixaService(
  private val rendaFixaRepository: RendaFixaRepository,
  private val rendaFixaMapper: RendaFixaMapper
) {

  private val logger = KotlinLogging.logger {}

  fun cadastrarRendaFixa(request: CadastrarRendaFixaRequest) {
    val rendaFixa = rendaFixaMapper.toModel(request)





    logger.info { "cadastrar renda fixa $rendaFixa" }
  }
}
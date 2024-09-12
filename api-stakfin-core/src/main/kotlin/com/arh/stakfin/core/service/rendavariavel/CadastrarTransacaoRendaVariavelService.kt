package com.arh.stakfin.core.service.rendavariavel

import com.arh.stakfin.core.mapper.RendaVariavelMapper
import com.arh.stakfin.core.model.rendavariavel.TransacaoRendaVariavel
import com.arh.stakfin.core.persistence.rendavariavel.repository.TransacaoRendaVariavelRepository
import com.arh.stakfin.core.web.request.TransacaoRendaVariavelRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CadastrarTransacaoRendaVariavelService(
  private val transacaoRendaVariavelRepository: TransacaoRendaVariavelRepository,
  private val rendaVariavelMapper: RendaVariavelMapper
) {

  private val logger = KotlinLogging.logger {}

  fun registrar(request: TransacaoRendaVariavelRequest): TransacaoRendaVariavel {
    logger.info { "criar renda variavel $request" }

    val model = rendaVariavelMapper.toModel(request)
    val entity = rendaVariavelMapper.toEntity(model)

    val savedEntity = transacaoRendaVariavelRepository.save(entity)

    return rendaVariavelMapper.toModel(savedEntity)
  }

}
package com.arh.stakfin.core.service.rendavariavel

import com.arh.stakfin.core.mapper.RendaVariavelMapper
import com.arh.stakfin.core.model.exception.RendaFixaAtivoNotFoundException
import com.arh.stakfin.core.model.exception.TransacaoRendaVariavelNotFoundException
import com.arh.stakfin.core.model.rendavariavel.TransacaoRendaVariavel
import com.arh.stakfin.core.persistence.rendavariavel.repository.TransacaoRendaVariavelRepository
import org.springframework.stereotype.Service

@Service
class TransacaoRendaVariavelService(
  private val transacaoRendaVariavelRepository: TransacaoRendaVariavelRepository,
  private val rendaVariavelMapper: RendaVariavelMapper
) {


  fun findById(id: Long): TransacaoRendaVariavel {
    val entity = transacaoRendaVariavelRepository.findById(id).orElseThrow {
      throw TransacaoRendaVariavelNotFoundException(mapOf("id" to id.toString()))
    }

    return rendaVariavelMapper.toModel(entity)
  }

}
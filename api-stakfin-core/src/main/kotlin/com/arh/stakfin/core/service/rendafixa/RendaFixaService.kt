package com.arh.stakfin.core.service.rendafixa

import com.arh.stakfin.core.mapper.RendaFixaMapper
import com.arh.stakfin.core.model.RendaFixaAtivo
import com.arh.stakfin.core.model.exception.RendaFixaAtivoNotFoundException
import com.arh.stakfin.core.persistence.repository.RendaFixaAtivoRepository
import org.springframework.stereotype.Service

@Service
class RendaFixaService(
  private val rendaFixaAtivoRepository: RendaFixaAtivoRepository,
  private val rendaFixaMapper: RendaFixaMapper
) {

  @Throws(RendaFixaAtivoNotFoundException::class)
  fun findById(id: Long): RendaFixaAtivo {
    val entity =
      rendaFixaAtivoRepository.findById(id).orElseThrow {
        throw RendaFixaAtivoNotFoundException(mapOf("id" to id.toString()))
      }

    return rendaFixaMapper.toModel(entity)
  }
}

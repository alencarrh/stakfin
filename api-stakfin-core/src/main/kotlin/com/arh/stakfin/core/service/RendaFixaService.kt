package com.arh.stakfin.core.service

import com.arh.stakfin.core.mapper.RendaFixaMapper
import com.arh.stakfin.core.model.exception.RendaFixaAtivoNotFoundException
import com.arh.stakfin.core.model.rendafixa.RendaFixaAtivo
import com.arh.stakfin.core.persistence.rendafixa.repository.RendaFixaRepository
import kotlin.jvm.Throws
import org.springframework.stereotype.Service

@Service
class RendaFixaService(
    private val rendaFixaRepository: RendaFixaRepository,
    private val rendaFixaMapper: RendaFixaMapper
) {

  @Throws(RendaFixaAtivoNotFoundException::class)
  fun findById(id: Long): RendaFixaAtivo {
    val entity =
        rendaFixaRepository.findById(id).orElseThrow {
          throw RendaFixaAtivoNotFoundException(mapOf("id" to id.toString()))
        }

    return rendaFixaMapper.toModel(entity)
  }
}

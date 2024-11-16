package com.arh.stakfin.core.service

import com.arh.stakfin.core.mapper.RendaFixaMapper
import com.arh.stakfin.core.model.RendaFixaAtivo
import com.arh.stakfin.core.model.exception.RendaFixaAtivoNotFoundException
import com.arh.stakfin.core.persistence.repository.RendaFixaAtivoRepository
import com.arh.stakfin.core.service.rendafixa.CadastrarRendaFixaService
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import org.springframework.stereotype.Service

@Service
class RendaFixaService(
    private val rendaFixaAtivoRepository: RendaFixaAtivoRepository,
    private val rendaFixaMapper: RendaFixaMapper,
    private val cadastrarRendaFixaService: CadastrarRendaFixaService
) {

  fun cadastrar(request: CadastrarRendaFixaRequest): RendaFixaAtivo {
    return cadastrarRendaFixaService.cadastrar(request)
  }

  @Throws(RendaFixaAtivoNotFoundException::class)
  fun findById(id: Long): RendaFixaAtivo {
    val entity =
        rendaFixaAtivoRepository.findById(id).orElseThrow {
          throw RendaFixaAtivoNotFoundException(mapOf("id" to id.toString()))
        }

    return rendaFixaMapper.toModel(entity)
  }
}

package com.arh.stakfin.core.service.rendafixa

import com.arh.stakfin.core.mapper.RendaFixaMapper
import com.arh.stakfin.core.model.rendafixa.RendaFixaAtivo
import com.arh.stakfin.core.persistence.rendafixa.repository.RendaFixaRepository
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class CadastrarRendaFixaService(
    private val rendaFixaRepository: RendaFixaRepository,
    private val rendaFixaMapper: RendaFixaMapper
) {

  private val logger = KotlinLogging.logger {}

  fun cadastrar(request: CadastrarRendaFixaRequest): RendaFixaAtivo {
    // TODO deveria converter de request para entity diretamente? faz sentido?
    // com certeza seria mais otimizado

    val rendaFixa = rendaFixaMapper.toModel(request)
    val entity = rendaFixaMapper.toEntity(rendaFixa)
    val rendaFixaSaved = rendaFixaRepository.save(entity)

    return rendaFixaMapper.toModel(rendaFixaSaved)
  }
}

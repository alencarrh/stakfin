package com.arh.stakfin.core.service.rendafixa

import com.arh.stakfin.core.mapper.RendaFixaMapper
import com.arh.stakfin.core.mapper.TransacaoMapper
import com.arh.stakfin.core.model.RendaFixaAtivo
import com.arh.stakfin.core.model.enums.TransacaoTipo
import com.arh.stakfin.core.persistence.repository.RendaFixaAtivoRepository
import com.arh.stakfin.core.persistence.repository.TransacaoRepository
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CadastrarRendaFixaService(
    private val repository: RendaFixaAtivoRepository,
    private val transacaoRepository: TransacaoRepository,
    private val rendaFixaMapper: RendaFixaMapper,
    private val transacaoMapper: TransacaoMapper
) {

  private val logger = KotlinLogging.logger {}

  @Transactional
  fun cadastrar(request: CadastrarRendaFixaRequest): RendaFixaAtivo {
    logger.info { "Cadastrando renda fixa: $request" }

    val rendaFixa = rendaFixaMapper.toNewEntity(request)
    val rendaFixaSaved = repository.save(rendaFixa)

    val transacao =
        transacaoMapper.toNewEntity(request.transacao, rendaFixaSaved.id, TransacaoTipo.RENDA_FIXA)
    transacaoRepository.save(transacao)

    return rendaFixaMapper.toModel(rendaFixaSaved)
  }
}

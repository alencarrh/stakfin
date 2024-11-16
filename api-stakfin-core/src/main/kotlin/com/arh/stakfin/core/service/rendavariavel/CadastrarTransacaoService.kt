package com.arh.stakfin.core.service.rendavariavel

import com.arh.stakfin.core.mapper.RendaVariavelMapper
import com.arh.stakfin.core.mapper.TransacaoMapper
import com.arh.stakfin.core.model.RendaVariavelAtivo
import com.arh.stakfin.core.model.enums.TransacaoTipo
import com.arh.stakfin.core.persistence.entity.RendaVariavelAtivoEntity
import com.arh.stakfin.core.persistence.repository.RendaVariavelAtivoRepository
import com.arh.stakfin.core.persistence.repository.TickerRepository
import com.arh.stakfin.core.persistence.repository.TransacaoRepository
import com.arh.stakfin.core.web.request.CadastrarTransacaoRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CadastrarTransacaoService(
    private val repository: RendaVariavelAtivoRepository,
    private val rendaVariavelMapper: RendaVariavelMapper,
    private val transacaoMapper: TransacaoMapper,
    private val transacaoRepository: TransacaoRepository,
    private val tickerRepository: TickerRepository
) {

  private val logger = KotlinLogging.logger {}

  fun cadastrar(request: CadastrarTransacaoRequest): RendaVariavelAtivo? {

    // 1 - Saber se já existe um ativo para este ticker usuário
    // 2 - se não existir, é necessário criar
    // 3 - se existir, é necessário cadastrar uma nova transação e atualizar o ativo principal
    // consolidado
    val ativoExistente = repository.findByTicker_Id(request.ticker)

    if (ativoExistente.isEmpty) {
      return criarAtivo(request)
    } else {
      return atualizarAtivo(ativoExistente.get(), request)
    }
  }

  private fun criarAtivo(request: CadastrarTransacaoRequest): RendaVariavelAtivo? {
    val ticker =
        tickerRepository.findById(request.ticker).orElseThrow {
          throw RuntimeException("Ticker não encontrado")
        }

    val ativo = rendaVariavelMapper.toNewEntity(request, ticker)
    val savedAtivo = repository.save(ativo)

    val transacao =
        transacaoMapper.toNewEntity(request.transacao, savedAtivo.id, TransacaoTipo.RENDA_VARIAVEL)
    transacaoRepository.save(transacao)
    return rendaVariavelMapper.toModel(savedAtivo)
  }

  private fun atualizarAtivo(
      ativo: RendaVariavelAtivoEntity,
      request: CadastrarTransacaoRequest
  ): RendaVariavelAtivo? {

    return null
  }
}

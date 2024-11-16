package com.arh.stakfin.core.service

import com.arh.stakfin.core.model.RendaVariavelAtivo
import com.arh.stakfin.core.service.rendavariavel.CadastrarTransacaoService
import com.arh.stakfin.core.web.request.CadastrarTransacaoRequest
import org.springframework.stereotype.Service

@Service
class RendaVariavelService(
    private val cadastrarTransacaoService: CadastrarTransacaoService,
) {

  fun cadastrar(request: CadastrarTransacaoRequest): RendaVariavelAtivo? {
    return cadastrarTransacaoService.cadastrar(request)
  }
}

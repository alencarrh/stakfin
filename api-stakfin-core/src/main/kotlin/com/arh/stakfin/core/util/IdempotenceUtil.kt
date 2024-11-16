package com.arh.stakfin.core.util

import com.arh.stakfin.core.model.enums.TransacaoTipo
import com.arh.stakfin.core.persistence.entity.TickerEntity
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import com.arh.stakfin.core.web.request.CadastrarTransacaoRequest
import com.arh.stakfin.core.web.request.TransacaoRequest
import org.apache.commons.codec.digest.DigestUtils

class IdempotenceUtil {
  companion object {
    @JvmStatic
    fun newTransacaoIdempotence(
        transacao: TransacaoRequest,
        ativoId: Long,
        tipo: TransacaoTipo
    ): String {
      return DigestUtils.sha256Hex(transacao.getIdempotenceFields() + "-$ativoId-$tipo")
    }

    @JvmStatic
    fun newAtivoRendaFixa(request: CadastrarRendaFixaRequest): String {
      return DigestUtils.sha256Hex(request.transacao.getIdempotenceFields())
    }

    @JvmStatic
    fun newAtivoRendaVariavel(request: CadastrarTransacaoRequest, ticker: TickerEntity): String {
      return DigestUtils.sha256Hex(request.transacao.getIdempotenceFields() + "-${ticker.id}")
    }
  }
}

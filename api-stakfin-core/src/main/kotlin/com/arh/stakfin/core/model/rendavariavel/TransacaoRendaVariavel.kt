package com.arh.stakfin.core.model.rendavariavel

import com.arh.stakfin.core.model.AcaoTransacao
import java.time.LocalDate

data class TransacaoRendaVariavel(
  val id: Long,
  val acao: AcaoTransacao,
  val ticker: String, // atualizar para Ticker
  val data: LocalDate,
  val quantidade: Int,
  val valorUnitario: Long,
)

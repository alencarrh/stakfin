package com.arh.stakfin.core.model.rendavariavel

import java.time.LocalDate

data class RendaVariavelAtivo(
  val id: Long,
  val ticker: String,
  val dataCompra: LocalDate,
  val quantidade: Int,
  val valorUnitario: Long,
)

package com.arh.stakfin.core.model

import java.time.LocalDate

data class Transacao(
  val id: Long = 0,
  val data: LocalDate,
  val tipo: AcaoTransacao,
  val classe: ClasseAtivo,
  val ativoId: String,
)

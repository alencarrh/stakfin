package com.arh.ordersystem.orderapi.model

import java.time.LocalDate

data class Transacao(
  val id: Long = 0,
  val data: LocalDate,
  val tipo: TipoTransacao,
  val classe: ClasseAtivo,
  val ativoId: String,
)

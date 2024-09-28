package com.arh.stakfin.core.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Ticker(
  val id: String,
  val nome: String,
  val setor: String,
  val segmento: String,
  val ultimoValor: Long,
  val dataUltimoValor: LocalDate,
  val updatedAt: LocalDateTime
)

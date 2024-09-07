package com.arh.ordersystem.orderapi.model.rendavariavel

import java.time.LocalDate

data class RendaVariavelAtivo(
  val id: Long,
  val tickerId: Ticker, // talvez usar ticketId no futuro
  val dataCompra: LocalDate,
  val quantidade: Int,
  val valorUnitario: Long,
) {}

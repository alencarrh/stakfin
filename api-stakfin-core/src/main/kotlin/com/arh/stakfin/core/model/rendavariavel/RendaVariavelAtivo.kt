package com.arh.stakfin.core.model.rendavariavel

import java.time.LocalDate

data class RendaVariavelAtivo(
    val id: Long,
    val ticker: String, // atualizar para Ticker
    val dataCompra: LocalDate,
    val quantidade: Int,
    val valorUnitario: Long,
)

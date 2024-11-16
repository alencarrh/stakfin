package com.arh.stakfin.core.model

import com.arh.stakfin.core.model.enums.RendaFixaIndexador
import com.arh.stakfin.core.model.enums.RendaFixaStatus
import com.arh.stakfin.core.model.enums.RendaFixaTipo
import java.time.LocalDate
import java.time.LocalDateTime

data class RendaFixaAtivo(
    val id: Long,
    val usuarioId: Long,
    val emissor: String,
    val taxaAa: Long,
    val tipo: RendaFixaTipo,
    val indexador: RendaFixaIndexador,
    val dataCompra: LocalDate,
    val dataVencimento: LocalDate,
    val dataVenda: LocalDate?,
    val status: RendaFixaStatus,
    val quantidadeCompra: Int,
    val valorCompra: Long,
    val quantidadeTotalVenda: Int?,
    val valorTotalVenda: Long?,
    val createdAt: LocalDateTime?
)

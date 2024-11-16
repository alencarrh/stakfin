package com.arh.stakfin.core.model

import com.arh.stakfin.core.model.enums.RendaVariavelStatus
import java.time.LocalDateTime

data class RendaVariavelAtivo(
    val id: Long?,
    val usuarioId: Long,
    val ticker: Ticker,
    val taxaTotalCompra: Long,
    val taxaTotalVenda: Long?,
    val status: RendaVariavelStatus,
    val quantidadeTotalCompra: Int,
    val quantidadeTotalVenda: Int?,
    val valorTotalCompra: Long,
    val valorTotalVenda: Long?,
    val pm: Long,
    val createdAt: LocalDateTime?
)

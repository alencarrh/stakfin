package com.arh.stakfin.core.model

import com.arh.stakfin.core.model.enums.TransacaoAcao
import com.arh.stakfin.core.model.enums.TransacaoTipo
import java.time.LocalDate
import java.time.LocalDateTime

data class Transacao(
    val id: Long?,
    val usuarioId: Long,
    val ativoId: Long?,
    val acao: TransacaoAcao,
    val tipo: TransacaoTipo,
    val quantidade: Int,
    val valorUnitario: Long,
    val dataTransacao: LocalDate,
    val createdAt: LocalDateTime?,
    val idempotenceKey: String
)

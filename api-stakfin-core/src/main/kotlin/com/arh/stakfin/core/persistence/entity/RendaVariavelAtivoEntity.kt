package com.arh.stakfin.core.persistence.entity

import com.arh.stakfin.core.model.enums.RendaVariavelStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import org.hibernate.annotations.CreationTimestamp

@Entity
@Table(name = "ativo_rendavariavel")
data class RendaVariavelAtivoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    val usuarioId: Long,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticker", nullable = false)
    val ticker: TickerEntity,
    val taxaTotalCompra: Long,
    var taxaTotalVenda: Long?,
    @Enumerated(EnumType.STRING) val status: RendaVariavelStatus,
    val quantidadeTotalCompra: Int,
    val quantidadeTotalVenda: Int?,
    val valorTotalCompra: Long,
    val valorTotalVenda: Long?,
    val pm: Long,
    @CreationTimestamp val createdAt: LocalDateTime?,
    val idempotenceKey: String
)

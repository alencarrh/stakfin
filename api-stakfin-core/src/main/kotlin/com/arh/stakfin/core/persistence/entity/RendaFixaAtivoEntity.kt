package com.arh.stakfin.core.persistence.entity

import com.arh.stakfin.core.model.enums.RendaFixaIndexador
import com.arh.stakfin.core.model.enums.RendaFixaStatus
import com.arh.stakfin.core.model.enums.RendaFixaTipo
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime
import org.hibernate.annotations.CreationTimestamp

@Entity
@Table(name = "ativo_rendafixa")
data class RendaFixaAtivoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    val usuarioId: Long,
    val emissor: String,
    val taxaAa: Long,
    @Enumerated(EnumType.STRING) val tipo: RendaFixaTipo,
    @Enumerated(EnumType.STRING) val indexador: RendaFixaIndexador,
    val dataCompra: LocalDate,
    val dataVencimento: LocalDate,
    val dataVenda: LocalDate?,
    @Enumerated(EnumType.STRING) val status: RendaFixaStatus,
    val quantidadeCompra: Int,
    val valorCompra: Long,
    val quantidadeTotalVenda: Int?,
    val valorTotalVenda: Long?,
    @CreationTimestamp val createdAt: LocalDateTime?,
    val idempotenceKey: String
)

package com.arh.stakfin.core.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime
import org.hibernate.annotations.UpdateTimestamp

@Entity
@Table(name = "ticker")
data class TickerEntity(
    @Id val id: String,
    val nome: String,
    val setor: String?,
    val segmento: String?,
    val ultimoValor: Long,
    val dataUltimoValor: LocalDate,
    @UpdateTimestamp val updatedAt: LocalDateTime
)

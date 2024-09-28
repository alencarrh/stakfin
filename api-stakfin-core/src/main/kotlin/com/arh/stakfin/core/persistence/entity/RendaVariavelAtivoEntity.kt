package com.arh.stakfin.core.persistence.entity

import com.arh.stakfin.core.model.enums.RendaVariavelStatus
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "ativo_rendavariavel")
data class RendaVariavelAtivoEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val usuarioId: Long,
  @OneToOne
  val tickerEntity: TickerEntity,
  val dataCompra: LocalDate,
  val dataVenda: LocalDate,
  val taxaTotalCompra: Long,
  val taxaTotalVenda: Long,
  val status: RendaVariavelStatus,
  val quantidadeTotalCompra: Int,
  val quantidadeTotalVenda: Int,
  val valorTotalCompra: Long,
  val valorTotalVenda: Long,
  val pm: Long,
  @CreationTimestamp
  val createdAt: LocalDateTime
)
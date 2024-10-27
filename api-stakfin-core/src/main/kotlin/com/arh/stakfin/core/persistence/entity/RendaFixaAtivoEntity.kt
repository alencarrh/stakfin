package com.arh.stakfin.core.persistence.entity

import com.arh.stakfin.core.model.enums.RendaFixaIndexador
import com.arh.stakfin.core.model.enums.RendaFixaStatus
import com.arh.stakfin.core.model.enums.RendaFixaTipo
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "ativo_rendafixa")
data class RendaFixaAtivoEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val usuarioId: Long,
  val emissor: String,
  val taxaAa: Long,
  val tipo: RendaFixaTipo,
  val indexador: RendaFixaIndexador,
  val dataCompra: LocalDate,
  val dataVencimento: LocalDate,
  val dataVenda: LocalDate?,
  val status: RendaFixaStatus, // TODO check if saving string enum or order
  val quantidadeCompra: Int,
  val valorCompra: Long,
  val quantidadeTotalVenda: Int?,
  val valorTotalVenda: Long?,
  @CreationTimestamp
  val createdAt: LocalDateTime?
)
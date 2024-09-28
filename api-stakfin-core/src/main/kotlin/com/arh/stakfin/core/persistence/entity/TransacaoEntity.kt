package com.arh.stakfin.core.persistence.entity

import com.arh.stakfin.core.model.enums.TransacaoAcao
import com.arh.stakfin.core.model.enums.TransacaoTipo
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "transacao")
data class TransacaoEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val usuarioId: Long,
  val ativoId: Long,
  val acao: TransacaoAcao,
  val tipo: TransacaoTipo,
  val quantidade: Int,
  val valorUnitario: Long,
  val dataTransacao: LocalDate,
  @CreationTimestamp
  val createdAt: LocalDateTime
)


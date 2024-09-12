package com.arh.stakfin.core.persistence.rendavariavel.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "transacao_renda_variavel")
data class TransacaoRendaVariavelEntity(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
  val ticker: String,
  val data: LocalDate,
  val quantidade: Int,
  val valorUnitario: Long,
)

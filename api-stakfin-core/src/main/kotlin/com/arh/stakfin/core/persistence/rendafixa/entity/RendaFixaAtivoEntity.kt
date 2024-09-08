package com.arh.stakfin.core.persistence.rendafixa.entity

import com.arh.stakfin.core.model.rendafixa.RendaFixaIndexador
import com.arh.stakfin.core.model.rendafixa.RendaFixaTipo
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "renda_fixa_ativo")
data class RendaFixaAtivoEntity(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,
  val emissor: String,
  val tipo: RendaFixaTipo,
  val indexador: RendaFixaIndexador,
  val taxa: Long,
  val dataCompra: LocalDate,
  val dataVencimento: LocalDate,
  val valorInvestido: Long,
)

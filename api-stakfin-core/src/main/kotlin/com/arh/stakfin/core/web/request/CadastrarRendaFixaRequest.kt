package com.arh.stakfin.core.web.request

import com.arh.stakfin.core.model.rendafixa.RendaFixaIndexador
import com.arh.stakfin.core.model.rendafixa.RendaFixaTipo
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class CadastrarRendaFixaRequest(
  @field:NotBlank val emissor: String,
  @field:NotNull val tipo: RendaFixaTipo,
  @field:NotNull val indexador: RendaFixaIndexador,
  @field:NotNull @field:Min(1) val taxa: Long,
  @field:NotNull val dataCompra: LocalDate,
  @field:NotNull val dataVencimento: LocalDate,
  @field:NotNull @field:Min(1) val valorInvestido: Long,
)
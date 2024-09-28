package com.arh.stakfin.core.web.request

import com.arh.stakfin.core.model.enums.RendaFixaIndexador
import com.arh.stakfin.core.model.enums.RendaFixaTipo
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class CadastrarRendaFixaRequest(
  @field:NotNull @field:Valid val transacao: TransacaoRequest,
  @field:NotBlank val emissor: String,
  @field:NotNull val tipo: RendaFixaTipo,
  @field:NotNull val indexador: RendaFixaIndexador,
  @field:NotNull @field:Min(1) val taxaAa: Long,
  @field:NotNull val dataVencimento: LocalDate
)

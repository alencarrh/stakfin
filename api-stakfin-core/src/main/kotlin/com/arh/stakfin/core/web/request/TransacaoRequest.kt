package com.arh.stakfin.core.web.request

import com.arh.stakfin.core.model.enums.TransacaoAcao
import com.arh.stakfin.core.model.enums.TransacaoTipo
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class TransacaoRequest(
  @field:NotNull val acao: TransacaoAcao,
  @field:NotNull val tipo: TransacaoTipo,
  @field:NotNull @field:Min(1) val quantidade: Int,
  @field:NotNull @field:Min(1) val valorUnitario: Long,
  @field:NotNull val dataTransacao: LocalDate,
)

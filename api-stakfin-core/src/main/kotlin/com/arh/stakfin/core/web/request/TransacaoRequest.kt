package com.arh.stakfin.core.web.request

import com.arh.stakfin.core.model.enums.TransacaoAcao
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class TransacaoRequest(
    @field:NotNull val acao: TransacaoAcao,
    @field:NotNull @field:Min(1) val quantidade: Int,
    @field:NotNull @field:Min(1) val valorUnitario: Long,
    @field:NotNull @field:Min(0) val valorTaxa: Long,
    @field:NotNull val dataTransacao: LocalDate,
) {

  @JsonIgnore
  fun getIdempotenceFields(): String {
    return "${this.acao}" +
        "-${this.quantidade}" +
        "-${this.valorUnitario}" +
        "-${this.valorTaxa}" +
        "-${this.dataTransacao}"
  }
}

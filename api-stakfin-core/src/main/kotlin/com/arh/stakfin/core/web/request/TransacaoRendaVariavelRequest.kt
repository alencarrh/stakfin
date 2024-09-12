package com.arh.stakfin.core.web.request

import com.arh.stakfin.core.model.AcaoTransacao
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class TransacaoRendaVariavelRequest(
    @field:NotNull val acao: AcaoTransacao,
    @field:NotBlank val ticker: String,
    @field:NotNull val data: LocalDate,
    @field:NotNull @field:Min(1) val quantidade: Int,
    @field:NotNull @field:Min(1) val valorUnitario: Long,
)

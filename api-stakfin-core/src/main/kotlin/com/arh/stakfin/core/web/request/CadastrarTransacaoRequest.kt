package com.arh.stakfin.core.web.request

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CadastrarTransacaoRequest(
    @field:NotNull @field:Valid val transacao: TransacaoRequest,
    @field:NotBlank val ticker: String,
    @field:NotBlank val corretora: String
)

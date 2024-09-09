package com.arh.stakfin.core.model.rendafixa

import java.time.LocalDate

/**
 * Exibir nome em tela como ex: CDB Banco Master PRE 14,62% ex: {tipo} {emissor} {indexador} {taxa}%
 */
data class RendaFixaAtivo(

    // dados na hora da compra
    val id: Long?,
    val emissor: String,
    val tipo: RendaFixaTipo,
    val indexador: RendaFixaIndexador,
    val taxa: Long,
    val dataCompra: LocalDate,
    val dataVencimento: LocalDate,
    val valorInvestido: Long,

    // dados em uma possível venda ou vencimento
    val dataVenda: LocalDate?,
    val valorLiquidado: Long?,
    // impostos/taxas
)

// para calcular rentabilidade,
// total dias = dataVencimento - dataCompra
// dias já passados = LocalDate.now() - dataCompra
// taxa por dia = taxa / total dias
// percentual rentabilidade = taxa por dia * dias já passados
// valor rentabilidade = valorInvestido * percentual rentabilidade

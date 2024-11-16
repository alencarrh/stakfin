package com.arh.stakfin.core.mapper

import com.arh.stakfin.core.model.RendaVariavelAtivo
import com.arh.stakfin.core.persistence.entity.RendaVariavelAtivoEntity
import com.arh.stakfin.core.persistence.entity.TickerEntity
import com.arh.stakfin.core.util.IdempotenceUtil
import com.arh.stakfin.core.web.request.CadastrarTransacaoRequest
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", imports = [IdempotenceUtil::class])
interface RendaVariavelMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "usuarioId", ignore = true)
  @Mapping(target = "ticker", source = "ticker")
  @Mapping(target = "taxaTotalVenda", ignore = true)
  @Mapping(target = "quantidadeTotalVenda", ignore = true)
  @Mapping(target = "valorTotalVenda", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "status", constant = "ATIVO")
  @Mapping(
      target = "quantidadeTotalCompra", expression = "java(request.getTransacao().getQuantidade())")
  @Mapping(
      target = "valorTotalCompra",
      expression =
          "java(request.getTransacao().getValorUnitario() * request.getTransacao().getQuantidade())")
  @Mapping(target = "taxaTotalCompra", expression = "java(request.getTransacao().getValorTaxa())")
  @Mapping(target = "pm", expression = "java(request.getTransacao().getValorUnitario())")
  @Mapping(
      target = "idempotenceKey",
      expression = "java(IdempotenceUtil.newAtivoRendaVariavel(request, ticker))")
  fun toNewEntity(
      request: CadastrarTransacaoRequest,
      ticker: TickerEntity
  ): RendaVariavelAtivoEntity

  fun toModel(entity: RendaVariavelAtivoEntity): RendaVariavelAtivo
}

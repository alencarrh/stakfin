package com.arh.stakfin.core.mapper

import com.arh.stakfin.core.model.RendaFixaAtivo
import com.arh.stakfin.core.persistence.entity.RendaFixaAtivoEntity
import com.arh.stakfin.core.util.IdempotenceUtil
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", imports = [IdempotenceUtil::class])
interface RendaFixaMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "usuarioId", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "dataVenda", ignore = true)
  @Mapping(target = "quantidadeTotalVenda", ignore = true)
  @Mapping(target = "valorTotalVenda", ignore = true)
  @Mapping(target = "status", constant = "ATIVO")
  @Mapping(target = "dataCompra", source = "transacao.dataTransacao")
  @Mapping(target = "quantidadeCompra", source = "transacao.quantidade")
  @Mapping(
      target = "valorCompra",
      expression =
          "java(request.getTransacao().getValorUnitario() * request.getTransacao().getQuantidade())")
  @Mapping(
      target = "idempotenceKey", expression = "java(IdempotenceUtil.newAtivoRendaFixa(request))")
  fun toNewEntity(request: CadastrarRendaFixaRequest): RendaFixaAtivoEntity

  fun toModel(entity: RendaFixaAtivoEntity): RendaFixaAtivo
}

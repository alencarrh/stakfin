package com.arh.stakfin.core.mapper

import com.arh.stakfin.core.model.RendaFixaAtivo
import com.arh.stakfin.core.persistence.entity.RendaFixaAtivoEntity
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface RendaFixaMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "dataVenda", ignore = true)
  fun toNewEntity(model: RendaFixaAtivo): RendaFixaAtivoEntity

  fun toModel(entity: RendaFixaAtivoEntity): RendaFixaAtivo

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "usuarioId", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "dataVenda", ignore = true)
  @Mapping(target = "quantidadeTotalVenda", ignore = true)
  @Mapping(target = "valorTotalVenda", ignore = true)
  @Mapping(target = "status", constant = "ATIVO")
  @Mapping(source = "transacao.dataTransacao", target = "dataCompra")
  @Mapping(source = "transacao.quantidade", target = "quantidadeCompra")
  @Mapping(target = "valorCompra", expression = "java(request.getTransacao().getValorUnitario() * request.getTransacao().getQuantidade())")
  fun toModel(request: CadastrarRendaFixaRequest): RendaFixaAtivo
}

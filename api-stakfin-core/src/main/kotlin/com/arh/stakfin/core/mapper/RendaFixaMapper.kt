package com.arh.stakfin.core.mapper

import com.arh.stakfin.core.model.rendafixa.RendaFixaAtivo
import com.arh.stakfin.core.web.request.CadastrarRendaFixaRequest
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
interface RendaFixaMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "dataVenda", ignore = true)
  @Mapping(target = "valorLiquidado", ignore = true)
  fun toModel(request: CadastrarRendaFixaRequest): RendaFixaAtivo
}
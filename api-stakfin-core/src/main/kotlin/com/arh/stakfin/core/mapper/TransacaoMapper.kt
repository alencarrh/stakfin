package com.arh.stakfin.core.mapper

import com.arh.stakfin.core.model.Transacao
import com.arh.stakfin.core.web.request.TransacaoRequest
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TransacaoMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "usuarioId", ignore = true)
  @Mapping(target = "ativoId", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  fun toModel(transacao: TransacaoRequest): Transacao


}
package com.arh.stakfin.core.mapper

import com.arh.stakfin.core.model.enums.TransacaoTipo
import com.arh.stakfin.core.persistence.entity.TransacaoEntity
import com.arh.stakfin.core.util.IdempotenceUtil
import com.arh.stakfin.core.web.request.TransacaoRequest
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", imports = [IdempotenceUtil::class])
interface TransacaoMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "usuarioId", ignore = true)
  @Mapping(target = "ativoId", source = "ativoId")
  @Mapping(target = "tipo", source = "tipo")
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(
      target = "idempotenceKey",
      expression = "java(IdempotenceUtil.newTransacaoIdempotence(transacao, ativoId, tipo))")
  fun toNewEntity(transacao: TransacaoRequest, ativoId: Long, tipo: TransacaoTipo): TransacaoEntity
}

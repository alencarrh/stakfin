package com.arh.stakfin.core.model.exception

import com.arh.stakfin.core.model.exception.base.AbstractException
import com.arh.stakfin.core.model.exception.base.ErrorCode

class RendaFixaAtivoNotFoundException(details: Map<String, String>) : AbstractException(
  errorCode = ErrorCode.NOT_FOUND_RENDA_FIXA_ATIVO, details
)
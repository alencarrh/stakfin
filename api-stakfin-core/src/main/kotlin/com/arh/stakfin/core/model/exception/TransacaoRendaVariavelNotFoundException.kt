package com.arh.stakfin.core.model.exception

import com.arh.stakfin.core.model.exception.base.AbstractException
import com.arh.stakfin.core.model.exception.base.ErrorCode.NOT_FOUND_TRANSACAO_RENDA_VARIAVEL

class TransacaoRendaVariavelNotFoundException(details: Map<String, String>) :
    AbstractException(errorCode = NOT_FOUND_TRANSACAO_RENDA_VARIAVEL, details)

package com.arh.stakfin.core.model.exception.base

import org.springframework.http.HttpStatus

enum class ErrorCode(val code: String, val message: String, val httpStatus: HttpStatus) {

  INTERNAL_SERVER_ERROR("IE01", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
  NOT_FOUND_RENDA_FIXA_ATIVO("RF_E0001", "Renda fixa ativo not found", HttpStatus.NOT_FOUND),
}

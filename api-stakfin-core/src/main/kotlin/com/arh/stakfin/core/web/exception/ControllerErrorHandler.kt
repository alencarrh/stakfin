package com.arh.stakfin.core.web.exception

import com.arh.stakfin.core.model.exception.base.AbstractException
import com.arh.stakfin.core.model.exception.base.ErrorMessage
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ControllerErrorHandler {

  private val log = KotlinLogging.logger {}

  @ResponseBody
  @ExceptionHandler(Exception::class)
  fun handleException(e: Exception): ErrorMessage {
    log.error { "Error: ${e.message} <> $e" }
    return ErrorMessage(
        code = "INTERNAL_SERVER_ERROR", message = "An error occurred while processing the request")
  }

  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException::class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ErrorMessage {
    val errors = e.fieldErrors.associate { it.field to it.defaultMessage }

    return ErrorMessage(code = "BAD_REQUEST", message = "Invalid request", details = errors)
  }

  @ResponseBody
  @ExceptionHandler(AbstractException::class)
  fun handleMethodArgumentNotValidException(e: AbstractException): ResponseEntity<ErrorMessage> {
    val errorMessage =
        ErrorMessage(code = e.errorCode.code, message = e.errorCode.message, details = e.details)

    return ResponseEntity(errorMessage, e.errorCode.httpStatus)
  }
}

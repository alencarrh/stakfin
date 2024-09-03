package com.arh.ordersystem.orderapi.web.exception

import com.arh.ordersystem.orderapi.model.exception.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ControllerErrorHandler {

  @ResponseBody
  @ExceptionHandler(Exception::class)
  fun handleException(e: Exception): Any {
    return e
  }

  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException::class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): Any {
    val errors = e.fieldErrors.associate { it.field to it.defaultMessage }

    return ErrorMessage(code = "BAD_REQUEST", message = "Invalid request", details = errors)
  }
}

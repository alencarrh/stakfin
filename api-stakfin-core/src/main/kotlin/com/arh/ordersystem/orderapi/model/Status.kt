package com.arh.ordersystem.orderapi.model

enum class Status {

  CREATED,
  VALIDATING,
  INVALIDATED,
  PROGRESS,
  FAILED,
  EXPIRED,
  PAID,
  REVERSED
}

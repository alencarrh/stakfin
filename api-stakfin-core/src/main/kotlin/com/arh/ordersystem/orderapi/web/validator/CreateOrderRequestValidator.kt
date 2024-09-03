package com.arh.ordersystem.orderapi.web.validator

import com.arh.ordersystem.orderapi.web.request.CreateOrderRequest

class CreateOrderRequestValidator {

  // Only validated business rules
  // like if payment method is credit card, credit card details should be present
  // if payment method is nupay, nupay details should be present
  fun validate(createOrderRequest: CreateOrderRequest) {
    throw NotImplementedError("CreateOrderRequestValidator.validate() not implemented")
  }
}

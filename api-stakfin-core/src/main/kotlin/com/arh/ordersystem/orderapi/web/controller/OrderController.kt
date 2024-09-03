package com.arh.ordersystem.orderapi.web.controller

import com.arh.ordersystem.orderapi.service.CreateOrderService
import com.arh.ordersystem.orderapi.web.request.CreateOrderRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/order")
class OrderController(val createOrderService: CreateOrderService) {

  private val logger = KotlinLogging.logger {}

  @PostMapping
  fun createOrder(@Valid @RequestBody request: CreateOrderRequest) {
    createOrderService.create(request)
    logger.info { "createOrder" }
  }

  @GetMapping("/{id}")
  fun getOrder(@PathVariable("id") id: String) {
    logger.info { "getOrder" }
  }
}

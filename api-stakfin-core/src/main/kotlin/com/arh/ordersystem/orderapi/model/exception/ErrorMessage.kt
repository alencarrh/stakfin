package com.arh.ordersystem.orderapi.model.exception

class ErrorMessage(
    val code: String,
    val message: String,
    val details: Map<String, String?> = emptyMap()
)

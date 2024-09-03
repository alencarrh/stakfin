package com.arh.ordersystem.orderapi.persistence.order.entity.order

data class SellerEntity(
    val accountId: String,
    val walletId: String,
    val taxDocument: String,
)

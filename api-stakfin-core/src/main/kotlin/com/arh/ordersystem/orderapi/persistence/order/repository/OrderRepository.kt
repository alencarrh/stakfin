package com.arh.ordersystem.orderapi.persistence.order.repository

import com.arh.ordersystem.orderapi.persistence.order.entity.OrderEntity
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<OrderEntity, String> {}

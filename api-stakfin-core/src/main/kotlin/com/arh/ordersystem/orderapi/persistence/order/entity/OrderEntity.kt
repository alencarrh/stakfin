package com.arh.ordersystem.orderapi.persistence.order.entity

import com.arh.ordersystem.orderapi.model.Status
import com.arh.ordersystem.orderapi.persistence.order.entity.order.BuyerEntity
import com.arh.ordersystem.orderapi.persistence.order.entity.order.PaymentDetailEntity
import com.arh.ordersystem.orderapi.persistence.order.entity.order.SellerEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "purchase_order")
data class OrderEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(name = "purchase_id", nullable = false) val purchaseId: String,
    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    val status: Status,
    @Column(name = "buyer", nullable = false) @JdbcTypeCode(SqlTypes.JSON) val buyer: BuyerEntity,
    @Column(name = "seller", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    val seller: SellerEntity,
    @Column(name = "payment_detail", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    val paymentDetail: PaymentDetailEntity,
    @Column(name = "metadata", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    val matadata: Map<String, String>?
)

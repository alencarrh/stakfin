package com.arh.ordersystem.orderapi.service

import com.arh.ordersystem.orderapi.model.Status
import com.arh.ordersystem.orderapi.persistence.order.entity.OrderEntity
import com.arh.ordersystem.orderapi.persistence.order.entity.order.BuyerEntity
import com.arh.ordersystem.orderapi.persistence.order.entity.order.PaymentDetailEntity
import com.arh.ordersystem.orderapi.persistence.order.entity.order.SellerEntity
import com.arh.ordersystem.orderapi.persistence.order.repository.OrderRepository
import com.arh.ordersystem.orderapi.web.request.CreateOrderRequest
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CreateOrderService(val orderRepository: OrderRepository) {

  private val logger = KotlinLogging.logger {}

  fun create(newOrder: CreateOrderRequest) {
    logger.info { "createOrder ${newOrder.purchaseId}" }

    orderRepository.save(
        OrderEntity(
            purchaseId = newOrder.purchaseId,
            status = Status.CREATED,
            buyer =
                BuyerEntity(
                    accountId = newOrder.buyer.accountId,
                    name = newOrder.buyer.name,
                    taxDocument = newOrder.buyer.taxDocument),
            seller =
                SellerEntity(
                    accountId = newOrder.seller.accountId,
                    walletId = "walletId none now",
                    taxDocument = "taxDocument none now",
                ),
            matadata = hashMapOf("key" to "value"),
            paymentDetail =
                PaymentDetailEntity(
                    paymentSummary =
                        PaymentDetailEntity.PaymentSummary(
                            baseAmount = newOrder.paymentDetail.paymentSummary.baseAmount,
                            buyerFee = newOrder.paymentDetail.paymentSummary.buyerFee,
                            sellerFee = newOrder.paymentDetail.paymentSummary.sellerFee,
                            coupons =
                                newOrder.paymentDetail.paymentSummary.coupons?.map {
                                  PaymentDetailEntity.PaymentSummary.Coupon(
                                      couponId = it.couponId, discountAmount = it.discountAmount)
                                }),
                    paymentMethod = newOrder.paymentDetail.paymentMethod,
                    creditCard =
                        newOrder.paymentDetail.creditCard?.let {
                          PaymentDetailEntity.PaymentDetailCreditCard(
                              cardId = it.cardId, installments = it.installments)
                        },
                    nupay =
                        newOrder.paymentDetail.nupay?.let {
                          PaymentDetailEntity.PaymentDetailNupay(
                              payerTaxDocument = it.payerTaxDocument)
                        },
                )))
  }
}

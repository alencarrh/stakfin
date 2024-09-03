package com.arh.ordersystem.orderapi.persistence.order.entity.order

import com.arh.ordersystem.orderapi.model.PaymentMethod

data class PaymentDetailEntity(
    val paymentSummary: PaymentSummary,
    val paymentMethod: PaymentMethod,
    val creditCard: PaymentDetailCreditCard?,
    val nupay: PaymentDetailNupay?,
    //  val pix: PaymentDetailPix?, //no additional information needed
) {
  data class PaymentSummary(
      val baseAmount: Long, // amount in cents
      val buyerFee: Long, // amount in cents
      val sellerFee: Long, // amount in cents
      val coupons: List<Coupon>?,
  ) {
    data class Coupon(
        val couponId: String,
        val discountAmount: Long // amount in cents
    )
  }

  data class PaymentDetailCreditCard(
      val cardId: String,
      val installments: Int,
  )

  data class PaymentDetailNupay(
      val payerTaxDocument: String,
  )
}

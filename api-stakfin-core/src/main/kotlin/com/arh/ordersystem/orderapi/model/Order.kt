package com.arh.ordersystem.orderapi.model

data class Order(
    val id: Long,
    val purchaseId: String,
    val buyer: Buyer,
    val seller: Seller,
    val paymentDetail: PaymentDetail,
    val status: Status,
    val matadata: Map<String, String>
) {

  data class Seller(
      val accountId: String,
      val walletId: String,
  )

  data class Buyer(
      val accountId: String,
      val name: String,
      val taxDocument: String,
  )

  data class PaymentDetail(
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
}

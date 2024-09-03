package com.arh.ordersystem.orderapi.web.request

import com.arh.ordersystem.orderapi.model.PaymentMethod
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateOrderRequest(
    @field:NotBlank val purchaseId: String,
    @field:Valid @field:NotNull val buyer: CreateOrderBuyerRequest,
    @field:Valid @field:NotNull val seller: CreateOrderSellerRequest,
    @field:Valid @field:NotNull val paymentDetail: PaymentDetailRequest,
    val metadata: Map<String, String>?
)

data class CreateOrderBuyerRequest(
    @field:NotBlank val accountId: String,
    @field:Size(min = 1) val name: String?,
    @field:Size(min = 1, max = 14) val taxDocument: String?
)

data class CreateOrderSellerRequest(@field:NotBlank val accountId: String)

data class PaymentDetailRequest(
    @field:Valid @field:NotNull val paymentSummary: PaymentSummaryRequest,
    @field:NotNull val paymentMethod: PaymentMethod,
    @field:Valid val creditCard: PaymentDetailCreditCardRequest?,
    @field:Valid val nupay: PaymentDetailNupayRequest?,
    //  val pix: PaymentDetailPix?, //no additional information needed
) {
  data class PaymentSummaryRequest(
      @field:NotNull @field:Min(1) val baseAmount: Long, // amount in cents
      @field:NotNull @field:Min(0) val buyerFee: Long, // amount in cents
      @field:NotNull @field:Min(0) val sellerFee: Long, // amount in cents
      @field:Valid val coupons: List<Coupon>?,
  ) {
    data class Coupon(
        @field:NotNull val couponId: String,
        @field:NotNull val discountAmount: Long // amount in cents
    )
  }

  data class PaymentDetailCreditCardRequest(
      @field:NotBlank val cardId: String,
      @field:NotNull @field:Min(1) val installments: Int,
  )

  data class PaymentDetailNupayRequest(
      @field:NotBlank val payerTaxDocument: String,
  )
}

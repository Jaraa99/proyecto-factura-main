package com.trade.billing.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "detail")
class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "quantity")
    var quantity: Int = 0

    @Column(name = "price", precision = 10, scale = 2)
    var price: BigDecimal? = null

    @Column(name = "invoice_id")
    var invoiceId: Long? = null

    @Column(name = "product_id")
    var productId: Long? = null
}
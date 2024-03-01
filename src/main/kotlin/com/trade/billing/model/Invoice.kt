package com.trade.billing.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.sql.Timestamp

@Entity
@Table(name = "invoice")
class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "code", unique = true)
    var code: String? = null

    @Column(name = "create_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    var createdAt: Timestamp? = null

    @Column(name = "total", precision = 10, scale = 2)
    var total: BigDecimal? = null

    @Column(name = "client_id")
    var clientId: Long? = null
}
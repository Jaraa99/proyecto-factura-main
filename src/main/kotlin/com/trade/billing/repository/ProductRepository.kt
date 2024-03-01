package com.trade.billing.repository

import com.trade.billing.model.Invoice
import com.trade.billing.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long?> {
    fun findById (id: Long?): Product?

}
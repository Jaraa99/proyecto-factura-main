package com.trade.billing.repository

import com.trade.billing.model.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?>{
    fun findById (id: Long?): Detail?

    @Query(nativeQuery = true)
    fun bestProductSeller(value:Long): List<*>
    fun findByInvoiceId(invoiceId: Long?) : List<Detail>

}
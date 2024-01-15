package com.trade.billing.repository

import com.trade.billing.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository :JpaRepository<Client, Long?>{
    fun findById (id: Long?): Client?
}
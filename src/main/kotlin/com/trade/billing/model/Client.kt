package com.trade.billing.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "client")
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "nui", unique = true)
    var nui: String? = null

    @Column(name = "fullname")
    var fullName: String? = null

    @Column(name = "address")
    var address: String? = null

    @Column(name = "email")
    var email: String?= null
}





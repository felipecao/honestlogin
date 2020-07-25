package com.github.felipecao.honestlogin.domain

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class MenuItem (
        @Id
        val id: Long,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val description: String,

        @Column(nullable = false)
        val price: BigDecimal,

        @Column(nullable = false)
        val imageUrl: String
)
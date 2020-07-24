package com.github.felipecao.honestlogin.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User (
        @Id
        val username: String,

        @Column(nullable = false)
        val password: String
)
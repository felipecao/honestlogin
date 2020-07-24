package com.github.felipecao.honestlogin.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

@Component
interface UserRepository : JpaRepository<User, String> {
    fun findByUsername(username: String): User?
}
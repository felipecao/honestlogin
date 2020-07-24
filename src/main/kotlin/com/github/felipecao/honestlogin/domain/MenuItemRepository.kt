package com.github.felipecao.honestlogin.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

@Component
interface MenuItemRepository : JpaRepository<MenuItem, Long> {
    override fun findAll(): List<MenuItem>
}
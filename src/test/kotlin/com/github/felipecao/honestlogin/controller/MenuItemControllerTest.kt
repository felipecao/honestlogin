package com.github.felipecao.honestlogin.controller

import com.github.felipecao.honestlogin.domain.MenuItem
import com.github.felipecao.honestlogin.domain.MenuItemRepository
import com.github.felipecao.honestlogin.randomBigDecimal
import com.github.felipecao.honestlogin.randomString
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class MenuItemControllerTest {

    private val menuItemRepository : MenuItemRepository = mock()

    private val menuItemController = MenuItemController(menuItemRepository)

    @Test
    fun `should return empty collection`() {
        val response = menuItemController.getMenuItems()

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(listOf<MenuItem>(), response.body)
    }

    @Test
    fun `should return two menu items`() {
        val menuItems = listOf(
                MenuItem(id = 1L, name = randomString(), description = randomString(), price = randomBigDecimal()),
                MenuItem(id = 2L, name = randomString(), description = randomString(), price = randomBigDecimal())
            )

        whenever(menuItemRepository.findAll()).thenReturn(menuItems)

        val response = menuItemController.getMenuItems()

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(menuItems, response.body)
    }
}
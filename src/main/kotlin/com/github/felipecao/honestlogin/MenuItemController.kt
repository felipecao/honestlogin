package com.github.felipecao.honestlogin

import com.github.felipecao.honestlogin.domain.MenuItem
import com.github.felipecao.honestlogin.domain.MenuItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuItemController(@Autowired private val menuItemRepository: MenuItemRepository) {

    @GetMapping("/api/menu/items")
    fun getMenuItems(): ResponseEntity<List<MenuItem>> {
        val menuItems = menuItemRepository.findAll()
        return ResponseEntity.ok().body(menuItems)
    }
}
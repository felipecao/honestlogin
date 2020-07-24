package com.github.felipecao.honestlogin.controller.web

import com.github.felipecao.honestlogin.domain.MenuItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MenuItemWebController(@Autowired private val menuItemRepository: MenuItemRepository) {

    @GetMapping("/web/menu/item")
    fun getMenuItems(model: Model): String {
        val menuItems = menuItemRepository.findAll()
        model.addAttribute("menuItems", menuItems);
        return "menu"
    }
}
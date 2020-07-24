package com.github.felipecao.honestlogin.controller.api

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@ExtendWith(SpringExtension::class)
@WebAppConfiguration
@SpringBootTest
class MenuItemControllerIntegrationTest(@Autowired private val wac: WebApplicationContext) {

	private val mockMvc = MockMvcBuilders
			.webAppContextSetup(this.wac)
			.apply<DefaultMockMvcBuilder>(springSecurity())
			.build()

	@Test
	fun `menu item endpoint fails for unauthenticated request`() {
		mockMvc.get("/api/menu/item")
				.andExpect {
					status { isUnauthorized }
				}
	}

	@Test
	@WithMockUser(username="user")
	fun `menu item endpoint succeeds for authenticated request`() {
		mockMvc.get("/api/menu/item")
				.andExpect {
					status { isOk }
					content { contentType(MediaType.APPLICATION_JSON) }
					jsonPath("$[0].name") {value("Pollo al Chipotle")}
					jsonPath("$[1].name") {value("Ternera Chimichurri al Josper")}
				}
	}

}

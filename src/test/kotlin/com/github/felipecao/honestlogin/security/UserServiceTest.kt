package com.github.felipecao.honestlogin.security

import com.github.felipecao.honestlogin.domain.User
import com.github.felipecao.honestlogin.domain.UserRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.security.core.userdetails.UsernameNotFoundException
import java.util.*

class UserServiceTest() {

    private val userRepository : UserRepository = mock()
    private val username = UUID.randomUUID().toString()

    private val userService: UserService = UserService(userRepository)

    @Test
    fun should_throw_exception_if_user_is_not_found() {
        whenever(userRepository.findByUsername(username)).thenReturn(null)

        assertThrows(UsernameNotFoundException::class.java) {
            userService.loadUserByUsername(username)
        }
    }

    @Test
    fun should_return_valid_user_if_username_exists() {
        whenever(userRepository.findByUsername(username)).thenReturn(User(username = username, password = ""))

        val userDetails = userService.loadUserByUsername(username)

        assertEquals(username, userDetails.username)
    }
}
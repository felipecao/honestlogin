package com.github.felipecao.honestlogin.security

import com.github.felipecao.honestlogin.domain.User
import com.github.felipecao.honestlogin.domain.UserRepository
import com.github.felipecao.honestlogin.randomString
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.security.core.userdetails.UsernameNotFoundException

class UserServiceTest() {

    private val userRepository : UserRepository = mock()
    private val username = randomString()

    private val userService: UserService = UserService(userRepository)

    @Test
    fun `should throw exception if user is not found`() {
        whenever(userRepository.findByUsername(username)).thenReturn(null)

        assertThrows(UsernameNotFoundException::class.java) {
            userService.loadUserByUsername(username)
        }
    }

    @Test
    fun `should return valid user if username exists`() {
        whenever(userRepository.findByUsername(username)).thenReturn(User(username = username, password = ""))

        val userDetails = userService.loadUserByUsername(username)

        assertEquals(username, userDetails.username)
    }
}
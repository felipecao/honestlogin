package com.github.felipecao.honestlogin.security

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthenticationEntryPoint : BasicAuthenticationEntryPoint() {

    override fun commence(request: HttpServletRequest, response: HttpServletResponse, authException: AuthenticationException) {
        response.addHeader("WWW-Authenticate", "Basic realm=\"${realmName}\"");
        response.status = HttpServletResponse.SC_UNAUTHORIZED;
    }

    override fun afterPropertiesSet() {
        realmName = "HonestLogin"
        super.afterPropertiesSet()
    }
}
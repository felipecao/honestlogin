package com.github.felipecao.honestlogin

import java.math.BigDecimal
import java.util.*

fun randomString() = UUID.randomUUID().toString()
fun randomBigDecimal() = BigDecimal.valueOf(Random().nextLong())
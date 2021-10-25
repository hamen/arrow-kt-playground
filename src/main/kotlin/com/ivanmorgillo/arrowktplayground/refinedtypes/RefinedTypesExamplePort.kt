package com.ivanmorgillo.arrowktplayground.refinedtypes

import arrow.refinement.Refined
import arrow.refinement.ensure

@JvmInline
value class Port private constructor(val value: Int) {
    companion object : Refined<Int, Port>(::Port, {
        ensure((it in 0..65535) to "$it should be in the closed range of 0..65535 to be a valid port number")
    })
}

suspend fun main() {
    val validPort = Port.orNull(100)
    println(validPort)

    val invalidPort = Port.orNull(70000)
    println(invalidPort)

    Port.fold(
        value = 70000,
        ifInvalid = { println("$it is invalid") },
        ifValid = { println("$it is valid") }
    )
}

package com.ivanmorgillo.arrowktplayground.refinedtypes

import arrow.refinement.Refined
import arrow.refinement.ensure

@JvmInline
value class Email private constructor(val value: String) {
    companion object : Refined<String, Email>(::Email, {
        ensure(it.contains("@") to "$it should contain an @ symbol to be a valid email.")
    })
}

suspend fun main() {
    Email.fold(
        value = "frank@castle.com",
        ifInvalid = { println("$it is invalid") },
        ifValid = { println("$it is valid") }
    )

//    val email = Email("frank")
//    println(email)

    val email = Email.orNull("frank@castle.com")
    email?.value.run { println(this) }

    val e = Email.require("Hold my beer")
    println(e)
}

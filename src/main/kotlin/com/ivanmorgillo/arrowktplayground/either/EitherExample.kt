package com.ivanmorgillo.arrowktplayground.either

import arrow.core.Either

suspend fun main() {
    println("Is it gonna be [Left] or [Right]? Suspance is killing me!!")
    val something = Either.catch { loadSomething() }
    println(something)
}

suspend fun loadSomething(): String {
    val isNotYourDay = (0..10).random() > 5
    if (isNotYourDay) throw RuntimeException("Life is harsh")
    return "Everything is awesome"
}

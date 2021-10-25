import arrow.core.Either

suspend fun main() {
    println("Loading... ⏳")
    val something = Either.catch { loadSomething() }
    println("Is it gonna be [Left] or [Right]? $something")
}

suspend fun loadSomething(): String {
    val isNotYourDay = (0..10).random() > 5
    if (isNotYourDay) throw RuntimeException("Life is harsh")

    return "Everything is awesome"
}

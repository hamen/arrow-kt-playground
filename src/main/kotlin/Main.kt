import arrow.core.Either
import arrow.fx.coroutines.Environment

fun main() {
    println("Loading... ⏳")

    val environment = Environment()
    environment.unsafeRunSync {
        val something = Either.catch { loadSomething() }
        println("Is it gonna be [Left] or [Right]? $something")
    }
}

suspend fun loadSomething(): String {
    val isNotYourDay = (0..10).random() > 5
    if (isNotYourDay) throw RuntimeException("Life is harsh")

    return "Everything is awesome"
}

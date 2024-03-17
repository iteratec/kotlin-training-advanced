import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun log(message: String) = println("[${Thread.currentThread().name}] $message")

fun main() = runBlocking {
    val first = async {
        log("first")
        21
    }
    val second = async {
        log("second")
        42
    }

    log("result: ${first.await() + second.await()}")
}

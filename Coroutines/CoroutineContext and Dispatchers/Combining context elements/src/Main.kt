import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun log(message: String) = println("[${Thread.currentThread().name}] $message")

fun main() = runBlocking {
    val first = async(Dispatchers.Default + CoroutineName("first")) {
        log("first")
        21
    }
    val second = async(CoroutineName("second")) {
        log("second")
        42
    }

    log("result: ${first.await() + second.await()}")
}

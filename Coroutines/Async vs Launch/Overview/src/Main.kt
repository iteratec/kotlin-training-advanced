import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            delay(1_000)
            println("Pokemon-World")
        }
        val deferred = async {
            delay(500)
            "Hello"
        }

        println(deferred.await())
    }
}

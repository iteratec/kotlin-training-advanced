import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, throwable ->
        println("catched $throwable in handler")
    }

    val job = GlobalScope.launch(handler) {
        throw IndexOutOfBoundsException()
    }
    job.join()
}
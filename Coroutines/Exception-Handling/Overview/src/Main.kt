import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {
        try {
            val job = GlobalScope.launch {
                println("launch started")
                // Exception will be handled by Thread.uncaughtException (position in console depends on runtime behaviour of coroutines)
                throw IndexOutOfBoundsException()
            }
            delay(10) // make sure launch will be executed first
            println("before join")
            job.join()
            println("after join")
        } catch (e: IndexOutOfBoundsException) {
            println("IndexOutOfBoundsException caught")
        }

        try {
            val deferred = GlobalScope.async {
                println("async started")
                throw ArithmeticException()
            }
            println("before await")
            deferred.await()
            println("after await")
        } catch (e: ArithmeticException) {
            println("ArithmeticException caught")
        }
    }
}
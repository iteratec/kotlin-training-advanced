import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    launch {
        println("main runBlocking      : ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        println("Unconfined            : ${Thread.currentThread().name}")
        delay(10)
        println("Unconfined            : ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        println("Default               : ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("NewThread")) {
        println("newSingleThreadContext: ${Thread.currentThread().name}")
    }
}
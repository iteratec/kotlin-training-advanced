import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val dataJob = launch(Dispatchers.Default) {
            var next = System.currentTimeMillis()
            var i = 0
            while (i < 10 && isActive) {
                if (System.currentTimeMillis() >= next) {
                    println("fetching data $i")
                    next += 200L
                    i++
                }
            }
        }
        delay(1500L)
        println("don't need data anymore")
        dataJob.cancelAndJoin() // convenience extension which cancels and joins in one call
        println("now the data job is canceled")
    }
}

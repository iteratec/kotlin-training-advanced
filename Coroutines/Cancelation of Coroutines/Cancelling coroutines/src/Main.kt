import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val dataJob = launch {
            repeat(1000) {
                println("fetching data $it")
                delay(200)
            }
        }

        delay(1500)
        println("don't need data anymore")
        dataJob.cancel()
        dataJob.join()
        println("now the data job is canceled")
    }
}
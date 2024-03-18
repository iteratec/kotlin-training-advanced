import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val numbers = flow {
        for (i in 1..5) {
            delay(100)
            emit(i)
        }
    }

    numbers.conflate().collect {
        delay(300)
        println(it)
    }
}
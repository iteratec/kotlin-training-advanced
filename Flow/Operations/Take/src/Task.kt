import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val numbers = flow {
        try {
            for (i in 1..10) {
                emit(i)
            }
        } finally {
            println("finally in numbers")
        }
    }

    numbers.take(4)
            .collect { println(it) }
}
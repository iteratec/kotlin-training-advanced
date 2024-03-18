import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val numbers = flow {
        for (i in 1..10) {
            println("emit $i")
            emit(i)
        }
    }

    numbers.filter { it % 2 == 0 }
            .collect { println(it) }
}
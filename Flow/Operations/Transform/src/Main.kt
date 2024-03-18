import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val numbers = flow {
        for (i in 1..10) {
            println("emit $i")
            emit(i)
        }
    }

    numbers.transform { if (it % 2 == 0) emit("number $it") }
            .collect { println(it) }
}
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.*

fun main() = runBlocking{
    val numbers = flow {
        //withContext(Dispatchers.IO) {
            for (i in 1..10) {
                Thread.sleep(100) // CPU intensive computation
                emit(i)
            }
        //}
    }.flowOn(Dispatchers.IO)

    numbers.collect { println(it) }
}

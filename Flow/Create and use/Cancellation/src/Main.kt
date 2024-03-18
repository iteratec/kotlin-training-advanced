import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val first = GlobalScope.launch {
        val flowBuilder = flow {
            for (i in 1..5) {
                println("add $i to flow")
                emit(i)
            }
        }

        flowBuilder.collect {
            if (it == 3) cancel()
            println("flow value $it")
        }
    }
    delay(10)

    val second = GlobalScope.launch {
        val flowAsFlow = (1..5).asFlow()

        flowAsFlow.collect {
            if (it == 3) cancel()
            println("asFlow value $it")
        }
    }

    joinAll(first, second)

    println("Done")
}

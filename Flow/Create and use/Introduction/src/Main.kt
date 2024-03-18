import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job1 = launch {
        val listValues = async {
            buildList {
                for (i in 1..5) {
                    delay(500)
                    println("add $i to list")
                    add("$i")
                }
            }
        }

        listValues.await().forEach { println("list value $it") }

        println("--------------------------")

        val seqValues = async {
            sequence {
                for (i in 1..5) {
                    Thread.sleep(500)
                    println("add $i to sequence")
                    yield("$i")
                }
            }
        }

        seqValues.await().forEach { println("sequence value $it") }

        println("--------------------------")

        val flow = flow {
            for (i in 1..5) {
                delay(500)
                println("add $i to flow")
                emit("$i")
            }
        }

        flow.collect { println("flow value $it") }
    }
    val job2 = launch {
        while(true) {
            println("do something else")
            delay(250)
        }
    }

    job1.join()
    job2.cancel()
}

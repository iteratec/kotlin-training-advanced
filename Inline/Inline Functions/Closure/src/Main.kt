import kotlin.random.Random

fun main() {

    val counter = createCounter { Random.nextInt(10) }

    println(counter())
    println(counter())
    println(counter())
}

inline fun createCounter(numberCreator: () -> Int): () -> Int {
    var count = numberCreator()
    return {
        count++
    }
}

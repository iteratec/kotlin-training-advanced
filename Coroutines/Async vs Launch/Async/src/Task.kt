import kotlinx.coroutines.*
import java.util.*

fun main() {
    runBlocking {
        val pikachuType = async { fetchPokemonType("pikachu") }
        val pikatchuHP = async { fetchPokemonHp("pikachu")}

        val bulbasaurType = async { fetchPokemonType("bulbasaur")}
        val bulbasaurHP = async { fetchPokemonHp("bulbasaur") }

        println(getStats(pikachuType, pikatchuHP))
        println(getStats(bulbasaurType, bulbasaurHP))
    }
}

suspend fun getStats(type: Deferred<String>, hp: Deferred<Int>): String {
    return "${type.await()}: HP - ${hp.await()}"
}

suspend fun fetchPokemonType(name: String): String {
    return when(name.lowercase(Locale.getDefault())) {
        "pikachu" -> {
            delay(1000)
            "Elektro"
        }
        "bulbasaur" -> {
            delay(300)
            "Gras/Gift"
        }
        else -> "Unbekanntes Pokémon"
    }
}

suspend fun fetchPokemonHp(name: String): Int {
    return when(name.lowercase(Locale.getDefault())) {
        "pikachu" -> {
            delay(100)
            35
        }
        "bulbasaur" -> {
            delay(900)
            45
        }
        else -> -1
    }
}
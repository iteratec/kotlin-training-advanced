import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Pokeball(
    val serializer: Json
) {

    var decodedPokemon: String? = null

    fun catch(pokemon: Bisasam) {
        decodedPokemon = try {
            serializer.encodeToString(pokemon).also {
                println("Catched: $it")
            }
        } catch (e: Exception) {
            println("Serialization failed: ${e.message}")
            null
        }
    }

    fun release(): Bisasam? = decodedPokemon?.let { decoded ->
        try {
            serializer.decodeFromString<Bisasam>(decoded).also {
                println("Releasing: $it")
                decodedPokemon = null
            }
        } catch (e: Exception) {
            println("Deserialization failed: ${e.message}")
            null
        }
    }
}


@Serializable
data class Bisasam(
    val sound: String? = null,
    val ability: String? = "Vine Whip",
    @Transient val generation: Int? = 1
)

val serializer = Json { encodeDefaults = true }

fun main() {

    val list = listOf(
        Bisasam(
            sound = "Bisa"
        ), Bisasam(
            sound = "Bisaaa"
        )
    )


    val pokeball = Pokeball(serializer)
    list.forEach {
        pokeball.catch(it)
        pokeball.release()
    }
}

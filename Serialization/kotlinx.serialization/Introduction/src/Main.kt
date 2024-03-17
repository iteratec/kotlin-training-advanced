import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Bisasam(
    val sound: String,
    val ability: String
)

fun main() {
    val bisasam = Bisasam("Bisa", "Vine Whip")
    Json.encodeToString(bisasam).also {
        println(it)
    }

    Json.decodeFromString<Bisasam>(
        """
          {
            "sound":"Biisaaaaa",
            "ability":"Tackle"
          }
        """.trimIndent()
    ).also {
        println(it)
    }

}

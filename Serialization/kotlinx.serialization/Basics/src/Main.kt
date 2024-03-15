import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Bisasam(
    val sound: String,
    val ability: String = "Vine Whip",
    val generation: Int = 1
)

class Main {
    companion object {
        private val serializer = Json
        fun encode(bisasam: Bisasam) = try {
            serializer.encodeToString(bisasam).also { println("Encoded: $it")}
        } catch (e: Exception) {
            println("Serialization failed: ${e.message}")
            null
        }

        fun decode(string: String) =
            try {
                serializer.decodeFromString<Bisasam>(string).also { println("Decoded: $it")}
            } catch (e: Exception) {
                println("Deserialization failed: ${e.message}")
                null
            }
    }
}

fun main() {

    optionalProperties()
    defaultProperties()

}

fun optionalProperties() {

    // Serialization will fail because of nullsafety checks at compile time.
    // Deserialization fails with an exception when non-null properties are missing
    // kotlinx.serialization respects type safety!
    Main.decode(
        """
          {
            "ability":"Tackle"
          }
        """.trimIndent()
    )
}

fun defaultProperties() {
    /*
     Default properties are not serialized
     There are two options to change this behavior
     - Modifying the JSON Serializer
     - Use the @EncodeDefault annotation
     */
    Main.encode(Bisasam(sound = "Bisaaaa"))
}

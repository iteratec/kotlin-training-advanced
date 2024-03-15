import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class Pokeball(
    private val serializer: Serializer = Serializer()
) {

    private var decoded: String? = null

    fun catch(bisasam: Bisasam) {
        decoded = encode(bisasam, serializer).also { println("Catched: $it") }
    }

    fun release(): Bisasam? = decoded?.let { decoded ->
        decode(decoded, serializer).also { println("Releasing: $it") }
    }

    companion object {
        fun encode(bisasam: Bisasam, serializer: Serializer = Serializer()) = try {
            serializer.encodeToString(bisasam)
        } catch (e: Exception) {
            println("Serialization failed: ${e.message}")
            null
        }

        fun decode(string: String, serializer: Serializer = Serializer()) =
            try {
                serializer.decodeString<Bisasam>(string)
            } catch (e: Exception) {
                println("Deserialization failed: ${e.message}")
                null
            }
    }

}

data class PokedexNumber(private val number: Int) {
    fun formatNumber(): String = "#%04d".format(number)
}

@Serializable
data class Bisasam(
    val sound: String = "Bisa",
    val ability: String = "Vine Whip",
    val generation: Int = 1,
    @Serializable(with = PokedexNumberSerializer::class)
    val pokedexNumber: PokedexNumber = PokedexNumber(1)
)

object PokedexNumberSerializer : KSerializer<PokedexNumber> {

    override val descriptor = PrimitiveSerialDescriptor("PokedexNumber", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: PokedexNumber) =
        encoder.encodeString(value.formatNumber())

    override fun deserialize(decoder: Decoder): PokedexNumber =
        PokedexNumber(
            decoder.decodeString()
                .drop(1)
                .toInt()
        )
}

fun main() {

    val pokeball = Pokeball(Serializer(encodeDefaults = true))
    pokeball.catch(Bisasam())
    pokeball.release()

}

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
class Serializer(
    encodeDefaults: Boolean = false,
    explicitNulls: Boolean = false,
    ignoreUnknownKeys: Boolean = false
) {

    val json = Json {
        this.encodeDefaults = encodeDefaults
        this.explicitNulls = explicitNulls
        this.ignoreUnknownKeys = ignoreUnknownKeys
    }

    inline fun <reified T> decodeString(value: String): T = json.decodeFromString(value)

    inline fun <reified T> encodeToString(value: T): String = json.encodeToString(value)

}

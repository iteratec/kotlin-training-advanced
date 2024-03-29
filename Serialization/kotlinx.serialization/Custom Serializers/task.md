# Custom Serializers

kotlinx.serializable only provides serializers for primitives and collections.

Every class marked with the `@Serializable` annotation, like the `Bisasam` class from the previous example, gets an instance of the `KSerializer` interface automatically generated by the Kotlin Serialization compiler plugin. 
The instance is available with `.serializer()` function on the class's companion object.

## KSerializer

There are multiple serializers available 
* For primitives like String, Long, Boolean
* For collections like List, Set, Map

To serialize other types like complex objects or wrappers a serializer must be available. 
Otherwise, the compiler will complain.

```kotlin
import java.util.*

object UUIDSerializer : KSerializer<UUID> {

    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}

@Serializable
data class Id(
    @Serializable(with = UUIDSerializer::class) 
    val uuid: UUID = UUID.randomUUID()
)
```

KSerializer has three required pieces.

* The `serialize` function implements SerializationStrategy. 
It receives an instance of Encoder and a value to serialize. 
It uses the encodeXxx functions of Encoder to represent a value as a sequence of primitives. 
There is an encodeXxx for each primitive type supported by serialization. 
In our example, encodeString is used.

* The `deserialize` function implements DeserializationStrategy. 
It receives an instance of Decoder and returns a deserialized value. 
It uses the decodeXxx functions of Decoder, which mirror the corresponding functions of Encoder. 
In our example decodeString is used.

* The `descriptor` property must faithfully explain what exactly the encodeXxx and decodeXxx functions do so that a format implementation knows in advance what encoding/decoding methods they call. 
Some formats might also use it to generate a schema for the serialized data. 
For primitive serialization, the PrimitiveSerialDescriptor function must be used with a unique name of the type that is being serialized. 
PrimitiveKind describes the specific encodeXxx/decodeXxx method that is being used in the implementation.

> When the descriptor does not correspond to the encoding/decoding methods, then the behavior of the resulting code is unspecified, and may arbitrarily change in future updates.

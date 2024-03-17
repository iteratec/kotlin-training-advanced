# Basics

## Serializable classes

Only class declarations with the `@Serializable` annotation are serializable.

```kotlin
@Serializable
data class Bisasam(
    val sound: String, 
    val ability: String
)
```

The entrypoint of the serialization facility is the `kotlinx.serialization.json.Json` object.
There are multiple methods available for de- / serialization.
For JSON serialization the following methods are key most likely.

```kotlin
fun main() {
    val bisasam = Bisasam("Bisa", "Tackle")
    val encoded: String = Json.encodeToString(bisasam)
    val decoded: Bisasam = Json.decodeFromString<Bisasam>(encoded)
}
```

## Behavior Modifiers

There are some control structures available to alter the serialization behavior.

### Default initializers

Default values on the serializable class are ignored by default.

```kotlin
@Serializable
data class Bisasam(
    val sound: String = "Bisa", 
    val ability: String = "Tackle"
)
```

There are two options to allow default values

#### Serializer Flag

```kotlin
Json { encodeDefaults = true }.encodeToString(Bisasam())
```

#### Annotation [@EncodeDefault](https://kotlinlang.org/api/kotlinx.serialization/kotlinx-serialization-core/kotlinx.serialization/-encode-default/)

Use the  annotation on the searializable class.
> This option is still experimental!

```kotlin
@Serializable
@OptIn(ExperimentalSerializationApi::class)
data class Bisasam(
    @EncodeDefault val sound: String = "Bisa", 
    @EncodeDefault val ability: String = "Tackle"
)
```

### Annotation [@Transient](https://kotlinlang.org/api/kotlinx.serialization/kotlinx-serialization-core/kotlinx.serialization/-transient/)

This annotation will prevent the serialization of attributes. 

> Does not affect decoding!

```kotlin
import kotlinx.serialization.Transient

@Serializable
data class Bisasam(
    val sound: String, 
    // This attribute will be ignored while serializing
    @Transient val ability: String = ""
)
```

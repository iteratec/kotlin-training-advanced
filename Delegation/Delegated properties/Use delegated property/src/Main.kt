import kotlin.properties.Delegates

class Pokemon(name: String) {
    // Create a mutable property "name" that uses the "observable" delegate and prints
    // a log message on every value change.
    var name: String by Delegates.observable(name) { property, oldValue, newValue ->
        println("Property ${property.name} changed from $oldValue to $newValue")
    }
}

fun main() {
    val pokemon = Pokemon("Pikachu")
    pokemon.name = "Squirtle"
    pokemon.name = "Bulbasaur"
}
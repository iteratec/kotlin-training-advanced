import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun audited(value: String): ReadWriteProperty<Pokemon, String> = AuditedProperty(value)

// Implement an AuditedProperty delegate, that logs accesses and changes to the
// underlying property
class AuditedProperty(private var value: String) : ReadWriteProperty<Pokemon, String> {

    override fun getValue(thisRef: Pokemon, property: KProperty<*>): String {
        println("Property ${property.name} has been read and has value $value")
        return value
    }

    override fun setValue(thisRef: Pokemon, property: KProperty<*>, value: String) {
        println("Property ${property.name} changed from ${this.value} to $value")
        this.value = value
    }
}



fun main() {
    val pokemon = Pokemon(name = "Pikachu")
    println(pokemon.name)
    pokemon.name = "Squirtle"
}

class Pokemon(name: String) {
    var name: String by audited(name)
}

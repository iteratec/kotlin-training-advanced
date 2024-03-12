import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Person(firstName: String) {

    private var firstNameAccessCounter: Int = 0

    val firstName: String = firstName
        get() {
            firstNameAccessCounter += 1
            println("Property firstName accessed $firstNameAccessCounter times")
            return field
        }
}

class AccessCounter(private val initValue: String) : ReadOnlyProperty<Person?, String> {

    private var counter: Int = 0

    override operator fun getValue(thisRef: Person?, property: KProperty<*>): String {
        counter += 1
        println("Property ${property.name} accessed $counter times")
        return initValue
    }
}

fun main() {
    val alice = Person(firstName = "Alice")
    alice.firstName
    alice.firstName
    alice.firstName
}

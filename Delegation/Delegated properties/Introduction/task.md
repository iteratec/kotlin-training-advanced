# Delegated properties
## Motivation
Sometimes you may want to perform some common logic, when a property is read or modified. For instance,
every time when a property is accessed, you may want to increment a counter. This functionality can be 
implemented directly in property's getter, but that kind of implementation is not shareable and must be
repeated for every property:

```kotlin
class Person(firstName: String) {

    private var accessCounter: Int = 0

    val firstName: String = firstName
        get() {
            accessCounter += 1
            println("Property firstName accessed $accessCounter times")
            return field
        }
}
```

Providing the same function for another property (e.g. `lastName`) would require us to duplicate all the code.
This is where delegated properties come in handy. You can view delegated properties as generic, reusable
getters & setters. With delegated properties the above code could be rewritten as:

```kotlin
class Person(firstName: String) {
    val firstName: String by AccessCounter(firstName)
}

class AccessCounter(private val initValue: String) {

    private var accessCounter: Int = 0
    
    operator fun getValue(thisRef: Person, property: KProperty<*>): String {
        accessCounter += 1
        println("Property ${property.name} accessed $accessCounter times")
        return initValue
    }
}
```
This way you can easily provide the additional access counting functionality to virtually any property without
duplicating the code.

## Anatomy
### Usage
Delegated properties can be used with local variables or class properties. To delegate a property, use the `by` keyword
where you'd normally provide the initializer:
```kotlin
// Local variable as delegated property
fun test() {
    val text: String by AccessCounter("hello")
    println(text)
}

// Delegated class property.
// Must be provided in class's body, declaration in a constructor is not supported.
class Person {
    val firstName: String by AccessCounter("Alice")
}
```

### Implementation
Delegates can be implemented as regular classes that contain two special functions `getValue()` and
`setValue()`. For read-only properties only the `getValue()` function is required. Both functions
must be declared as `operator` functions and have appropriate parameters:

```kotlin
class MyDelegate {
    
    /**
     * @param thisRef Reference to the object, that owns the delegated property
     * @param property meta-data of the delegate property
     */
    operator fun getValue(thisRef: OwnerType?, property: KProperty<*>): PropertyType {
    }

    /**
     * @param thisRef Reference to the object, that owns the delegated property
     * @param property meta-data of the delegate property
     * @param value new value set to the property
     */
    operator fun setValue(thisRef: OwnerType?, property: KProperty<*>, value: PropertyType?) {
    }
}
```
Kotlin provides two interfaces, that simplify delegate creation: `ReadOnlyProperty<OwnerType, PropertyType>`
and `ReadWriteProperty<OwnerType, PropertyType>`. You can memorize them instead of method signatures.

## Standard delegates
Kotlin provides few standard delegates:

### Lazy
Allows for lazy computation of property's value, when it is accessed for the first time. The delegate takes a lambda
function that will provide the property's value.
```kotlin
class IntSeries(val max: Int) {
    val primes: Set<Int> = lazy {
        computePrimesUpTo(max)
    }   
}
```

### Observable
The `observable` delegate allows to execute custom logic every time, when property's value changes. It takes an initial
property value and a callback to execute on change as parameters.

````kotlin
class Person {
    var name: String by observable("unnamed") { prop, old, new ->
        println("Property value changed: $old -> $new")
    }
}
````

## Usages
Delegates are great for providing framework-like functionality, but custom delegates should be rather avoided in regular
business code, unless there's a very good reason to use them. Some of interesting usages of delegates are:

### Mechanism for dependency injection
[Koin framework](https://insert-koin.io/) uses delegated properties in order to implement dependency injection:

```kotlin
class PersonService {
    private val repository : PersonRepository by inject()
}
```

### Mechanism for change detection
[Jetpack Compose](https://developer.android.com/jetpack/compose) uses delegated properties in order to notify the UI framework, when a property's value has changed.
This way, Compose can detect, when a certain UI component should be re-rendered.

```kotlin
@Composable
fun Header() {
    var count by remember { mutableStateOf(1) }
    Text(text = "Counter = $count", onClick = { count++ })
}
```
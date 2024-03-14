# Kotlin type hierarchy
In contrast to Java, Kotlin provides a more consistent and object-oriented type hierarchy
in this section, we'll briefly take a look at standard Kotlin types.

```text
          ┌─────┐                
  ┌──────►│ Any │◄────────┐      
  │       └─────┘         │      
  │          ▲            │      
  │          │            │      
  │          │            │      
┌─┴──┐   ┌───┴──┐   ┌─────┴─────┐
│Unit│   │Object│   │CustomTypes│
└────┘   └──────┘   └───────────┘
┌───────────────────────────────┐
│           Nothing             │
└───────────────────────────────┘
```

# Any
The `Any` type is the root type of all non-nullable types. This means, you can treat an arbitrary non-null
value as `Any`. `Any` provides 3 built-in methods: `equals`, `hashCode` and `toString`.

In order to use `Any` with `null`, you have to use its nullable counterpart `Any?`.

```kotlin
val a: Any = "string"
val b: Any = if (Random.nextBoolean()) 1 else "string"
val c: Any? = null
```

# Unit
The type `Unit` is a more object-oriented alternative to `void` from Java. It is used to denote
an absence of any meaningful value. `Unit` is a singleton at the same time, so there can be only
one instance of `Unit` within the JVM. 

`Unit` is the default return type for functions and lambdas, when no other type is specified. 
`Unit` can be used as any other type, which makes its usage much more concise than `void` in Java.

```kotlin
// Similar construction in Java is a bit problematic
val a: List<Unit> = listOf(Unit)

// Unit can be used in the same way as any other "normal" type
interface Worker<T> {
    fun doWork(): T
}

class NoResultWorker : Worker<Unit> {
    fun doWork() {
        // Perform some side effects
    }
}
```

# Object
`Object` type is Java-specific type, that is present in Kotlin only for compatibility reasons. `Object` is
a subtype of `Any` and contains few extra methods like `wait()` or `notify()`. When working in Kotlin,
you should almost never use `Object` and prefer `Any` instead. In contrast to Java `Object` is __not__
a root of the type hierarchy.

```kotlin
// Object is a subtype of Any
val a: Any = Object()

// Won't compile, Object is not a root type
val b: Object = String() 

```

# Nothing
`Nothing` is a special type, that indicates a value that never exists. You won't encounter `Nothing` very often, but it may sometimes appear as
a product of type inference. The type closely related to `Nothing` is `Nothing?`. The only valid
value of `Nothing?` is `null`.

Direct usage of `Nothing` is syntactically allowed, but is almost never needed.

```kotlin
// Won't compile, we can't assign any value to Nothing
val a: Nothing = "string"

// Null is the only value, we can assign to Nothing?
val b: Nothing? = null

// Nothing? will be the inferred type of the variable, we won't be able to reassign the value
var c = null
c = "string"

// Similarly, this expression will be inferred to be List<Nothing?>
val d: List<Nothing?> = listOf(null)

// Nothing is an inferred type of expressions that never return a value
val e: Nothing = throw RuntimeException()
```
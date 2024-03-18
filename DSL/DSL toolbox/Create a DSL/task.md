# Create a DSL
In this task we'll write a simple DSL that allows us to create a `Pokemon`.
Every `Pokemon` has the following properties:
* Name (String)
* Weight (Int)
* List of skills, where every skill consists of:
  * Name (String)
  * Power (Int)

Clients of our DSL would use it like this:
```kotlin
fun main() {
    val pikachu: Pokemon = pokemon {
        name = "Pikachu"
        weight = 2
        skills {
          skill(name = "Electrocute", power = 10)
          skill(name = "Thunderstorm", power = 35)
        }
    }

    println(pikachu)
}
```
Use lambdas with receiver to implement the above DSL.

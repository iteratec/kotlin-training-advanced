# Delegates
Delegates allow you to implement composition pattern without any boilerplate code. This way, you can create new
classes by combining behaviors implemented in already existing classes.

Delegates use syntax similar to the inheritance syntax. To create a delegate you need to
provide the delegated interface and a constructor parameter that accepts an implementor of this
interface:

```kotlin
interface AttackTrait {
    fun attack()
}

class ClawAttack : AttackTrait {
    override fun attack() {
        println("ClawAttack")
    }
}

class Pokemon(val name: String, attackTrait: AttackTrait) : AttackTrait by attackTrait

fun main() {
    val miauzi = Pokemon(name = "Miauzi", attackTrait = ClawAttack())
    
    // Call will be delegated to ClawAttack instance
    miauzi.attack()
}
```

All methods of the delegated interface will be then available directly from the delegating class.
You can specify multiple comma-separated delegators.

# Delegated properties
TODO
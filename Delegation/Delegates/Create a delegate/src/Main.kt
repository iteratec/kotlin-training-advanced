// Create a Pokemon class that  implements the CombatTrait interface and
// delegates its implementation to the provided constructor parameter.
class Pokemon(combatTrait: CombatTrait) : CombatTrait by combatTrait

fun main() {
    // Create a Pokemon instance that uses claw attack
    val meow = Pokemon(combatTrait = ClawAttack())
    meow.attack()

    // Create a Pokemon instance that uses electric attack
    val pikachu = Pokemon(combatTrait = ElectricAttack())
    pikachu.attack()
}



interface CombatTrait {
    fun attack()
}

class ClawAttack : CombatTrait {
    override fun attack() {
        println("Claw attack!")
    }
}

class ElectricAttack : CombatTrait {
    override fun attack() {
        println("Electric attack!")
    }
}
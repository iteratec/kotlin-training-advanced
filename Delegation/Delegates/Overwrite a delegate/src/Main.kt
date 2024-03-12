// Create a class PeacefulPokemon that implements the CombatTrait by delegation
// and overwrites the attack() method
class PeacefulPokemon(combatTrait: CombatTrait): CombatTrait by combatTrait {
    override fun attack() {
        println("Make love, not war.")
    }
}



fun main() {
    val snorlax = PeacefulPokemon(combatTrait = MeleeCombatTrait())
    snorlax.attack()
    snorlax.defend()
}

interface CombatTrait {
    fun attack()
    fun defend()
}

class MeleeCombatTrait : CombatTrait {
    override fun attack() {
        println("Claw attack!")
    }

    override fun defend() {
        println("Tries to dodge the attack.")
    }
}
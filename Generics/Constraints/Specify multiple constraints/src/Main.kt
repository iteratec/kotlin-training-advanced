class Omniball<T> where T : Named, T : HitPoints {

    private var creature: T? = null

    fun catch(creature: T) {
        if (creature.hp < 50) {
            this.creature = creature
            println("${creature.name} caught successfully!")
        } else {
            println("${creature.name} escaped!")
        }
    }

    fun getCreature(): T? = this.creature
}

interface Named {
    val name: String
}

interface HitPoints {
    var hp: Int
}

class Cat(
    override val name: String,
    override var hp: Int
) : Named, HitPoints {
    override fun toString(): String = name
}

fun main() {
    val healthyCat = Cat(name = "Bibi", hp = 80)
    val weakenedCat = Cat(name = "Bobo", hp = 20)

    // Catball is a special pokeball that catches only cats
    val catball = Omniball<Cat>()
    catball.catch(healthyCat)
    catball.catch(weakenedCat)

    println("Omniball contains currently ${catball.getCreature()}.")
}
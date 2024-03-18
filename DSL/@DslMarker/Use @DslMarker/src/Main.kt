data class Pokemon(
    val name: String,
    val weight: Int,
    val skills: List<Skill>
)
data class Skill(val name: String, val power: Int)

TODO()

fun pokemon(block: PokemonBuilder.() -> Unit): Pokemon = PokemonBuilder().apply { block() }.build()

class PokemonBuilder {

    var name: String = "Pokemon"
    var weight: Int = 1

    private val skills: MutableList<Skill> = mutableListOf()

    fun skills(block: SkillBuilder.() -> Unit) {
        val skillBuilder = SkillBuilder(this.skills)
        skillBuilder.block()
    }

    fun build(): Pokemon = Pokemon(
        name = name,
        weight = weight,
        skills = skills.toList()
    )

    class SkillBuilder(private val skills: MutableList<Skill>) {
        fun skill(name: String, power: Int) {
            skills.add(Skill(name, power))
        }
    }
}

fun main() {
    val pikachu = pokemon {
        name = "Pikachu"
        weight = 2
        skills {
            // name = "Meow" - should not be possible!
            skill(name = "Electrocute", power = 10)
            skill(name = "Thunderstorm", power = 35)
        }
    }

    println(pikachu)
}

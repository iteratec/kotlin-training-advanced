data class Pokemon(
    val name: String,
    val weight: Int,
    val skills: List<Skill>
)
data class Skill(val name: String, val power: Int)

fun pokemon(block: PokemonScope.() -> Unit): Pokemon = PokemonBuilder().apply { block() }.build()

interface PokemonScope {
    var name: String
    var weight: Int

    fun skills(block: SkillScope.() -> Unit)
}

interface SkillScope {
    fun skill(name: String, power: Int)
}

class PokemonBuilder : PokemonScope {

    override var name: String = "Pokemon"
    override var weight: Int = 1

    private val skills: MutableList<Skill> = mutableListOf()

    override fun skills(block: SkillScope.() -> Unit) {
        val skillBuilder = SkillBuilder(this.skills)
        skillBuilder.block()
    }

    fun build(): Pokemon = Pokemon(
        name = name,
        weight = weight,
        skills = skills.toList()
    )

    class SkillBuilder(private val skills: MutableList<Skill>) : SkillScope {
        override fun skill(name: String, power: Int) {
            skills.add(Skill(name, power))
        }
    }
}

fun main() {
    val pikachu = pokemon {
        name = "Pikachu"
        weight = 2
        skills {
            skill(name = "Electrocute", power = 10)
            skill(name = "Thunderstorm", power = 35)
        }
    }

    println(pikachu)
}

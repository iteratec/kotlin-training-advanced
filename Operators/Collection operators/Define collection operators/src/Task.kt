data class Pokemon(val name: String)

class Team(vararg members: Pokemon) {

    private val members: MutableList<Pokemon> = members.toMutableList()

    operator fun get(i: Int): Pokemon = members[i]
    operator fun set(i: Int, value: Pokemon) {
        members[i] = value
    }

    operator fun contains(member: Pokemon): Boolean = members.contains(member)
}
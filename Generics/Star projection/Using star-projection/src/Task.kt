fun isInfoComplete(info: PokemonInfo<*>): Boolean {
    return info.name != null && info.description != null
}


class PokemonInfo<T: CharSequence>(var name: T?, var description: T?)
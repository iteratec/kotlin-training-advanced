# Specify single constraint
We're about to create a generic `Pokeball` class. A pokeball can optionally store one `Pokemon` (or its subclass) and 
has two methods that allow to catch and retrieve a pokemon. Initially, the pokeball is empty.

Pokeball has a generic `catch(T)` method that allows us to catch a pokemon. However, only weakened 
pokemons that have less than 50 HP can be caught successfully. When the pokemon has been caught successfully,
a message `{Pokemon name} caught successfully!` should be printed. Otherwise, a message
`{Pokemon name} escaped!` should be printed.

Additionally, pokeball has a `getPokemon(): T?` method that allows us to retrieve the currently caught pokemon.

Implement the `Pokeball` class, so that the provided `main()` function runs successfully and produces the
desired output. Use upper bound constraint to make sure, that `Pokeball` always works with instances of
`Pokemon` or their subtypes.
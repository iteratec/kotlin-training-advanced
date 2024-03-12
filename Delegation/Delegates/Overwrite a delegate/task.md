# Overwrite a delegate
Sometimes you may want to overwrite a subset of delegated methods. In this task you will create a
`PeacefulPokemon`, that can defend according to its combat trait, but can't attack at all.

Implement the `PeacefulPokemon` class, so it delegates the `CombatTrait` interface. `PeacefulPokemon`
should overwrite the `attack()` method, so it outputs the text `Make love, not war.` instead of
forwarding the call to the delegate.
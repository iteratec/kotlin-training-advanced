# Specify multiple constraints
In this task we'll tweak our `Pokeball` from the previous task and turn it into an `Omniball`. 
Omniball can catch any creature that has a name and hit points. Those attributes are represented
by interfaces `Named` and `HitPoints`.

Create a generic `Omniball` class that imposes two constraints on its type parameter:
* the parameter must be a subtype of `Named`
* the parameter must be a subtype of `HitPoints`

The outputs and catching logic should be the same as in the previous task.

The provided `main()` function will try to catch a `Cat` that implements `Named` and `HitPoints`
interfaces.


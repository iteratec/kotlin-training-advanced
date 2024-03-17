# Coroutines

A **coroutine** is an instance of a suspendable computation.
It takes a block of code and run it concurrently against the rest of the program.
**Coroutines** running on threads. But they are not bound to a specific thread. A **coroutine** can switch the thread after it was suspended.

Example:
 - ***runBlocking*** creates a new CoroutineScope wherein the Coroutines are running
 - ***launch*** starts a new Coroutines
 - ***delay*** suspends the coroutine for the given amount of miliseconds
 - the second ***println*** will be executed after the coroutine is suspended
 - after the ***delay*** returns, the coroutine will continue and the first ***println*** will be executed.
 - As result we see in the console *Hello Pokemon-World*


## Suspend Functions
Suspend functions can be used like regular functions inside a coroutine (or other suspend function).
They can suspend the execution of the enclosing coroutine.
In example ***delay*** is a suspend function.
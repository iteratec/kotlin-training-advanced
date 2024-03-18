# Exception Handling

Exceptions in coroutines are handled in different ways depending on used coroutine-builders.

*launch*: Exception is propagated automatically

*async*: Exception is exposed to surrounding code block (e.q. with *await* call)

When the builders are used to create a root coroutine (coroutine which is not children of another 
coroutine), then the exception thrown in *launch* will be treated as *uncaught exception*.

Every unhandled exception from a child coroutine will cause the cancellation of the parents.

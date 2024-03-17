# Lazy started Async

We also can start async-coroutines lazily. If we set the start parameter to *CoroutineStart\.LAZY* the coroutine 
starts only if we invoke *await* or *start* of the deferred.

Try also to remove the call of *start* in line 11. What happens if we only use *await* to start the lazy coroutines?
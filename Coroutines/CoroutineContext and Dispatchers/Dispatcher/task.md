# CoroutineContext

The CoroutineContext is a set of different elements which describes the context in which a coroutine is executed.
The CoroutineContext can be set during the builder call or can be switched inside the Coroutine.
If we don't set explicit a context it will be inherited from the parent coroutine.

The most important elements are the *Job* of the coroutine and the *Dispatcher*.

## Dispatcher
The Dispatcher determines the thread(s) in which the coroutine is executed.

### Default
Used for heavy CPU load operations.

### IO
Used for API or Database calls.

### MAIN (Android)
The UI Thread. 

## Unconfined
The Unconfined Dispatchers firstly starts in the call thread. After the first suspension it resumes on a thread 
which will be determined by the suspending function. 
The unconfined dispatcher should not be used in general code!
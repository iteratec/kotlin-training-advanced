## Cancellation

Like coroutines flows should have a cooperative cancellation.
Every time the *flow* builder emits a value, it will be checked if the coroutine is cancelled.
However, the other builders don't check :-(
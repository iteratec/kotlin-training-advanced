# Debugging

## IDE
Set breakpoints in line 8, 12 and 16 and start the main function with the debugger.
On the right side of the debug-view you can see the coroutines and there current states.

## Logging
If you use the thread name for logging inside a coroutine only the thread name is shown.
Add the following JVM Options to the run configuration and try it again.

    -Dkotlinx.coroutines.debug

Now the thread name includes also the current coroutines name.
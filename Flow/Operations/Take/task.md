# Take

To limitate the size of the collected values you can use *take*. 
The simplest variant is to give the number of values you want to collect. If the limit is reached
the coroutine is cancelled (by throwing the CancellationException).

If you have set the limitaion more dynamically, you can use *takeWhile*.

Try to limitate the collected numbers to get only the first 4. Try  it with *take* and with *takeWhile*.
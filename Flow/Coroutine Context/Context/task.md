# Coroutine context

By default, the code-block from *flow* runs in the same coroutine context like the 
terminal operator (collect in this case).

Run the code and see the error message.

The code in flow has to preserve the context. This means it is not allow to call emit in a different
context to the terminal operator.

Try to fix the problem.



Tip: The solution is described in the error message ;-)
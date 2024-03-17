# Cooperative cancellation

To cancel a coroutine the coroutine code has to be cancellable. 
For example all suspending functions from `kotlinx.coroutines` (eq `delay`) are cancellable.

Run the code see what happens. Then try to change the coroutine code to make in cancellable.
# noinline Keyword

This keyword gives you control which functions should be inlined.
By marking parameters of inline functions with `noinline` you can avoid these functions to be inlined.

## inline Restrictions

* Inlinable lambdas can only be called inside inline functions or passed as inlinable arguments.
* Inlinable lambdas can not be stored in variables
* Inline functions cannot access private functions or variables
* Private functions cannot be inlined

# Visibility

Inline functions are restricted to be public.
This is because of how inlining works and the complications it introduces to the visibility of the functions code on the call site.

The body of an inline function gets copied directly at the call site during compilation.
If the function were marked as `private`, then the inlined code would only be accessible within the same file where the function is defined.

However, inlining effectively breaks this file-level encapsulation because the inlined code is copied into other files where the function is called. 
This would mean that the inlined code could potentially be accessible outside the file where the private function is defined, violating encapsulation.

To prevent this from happening and to maintain the encapsulation provided by private visibility, Kotlin does not allow private functions to be marked as inline. 
Instead, if you need to inline a function for performance reasons, you can consider using internal visibility, which allows the function to be accessed from within the same module but not outside of it.

## @PublishedApi

The `@PublishedApi` annotation is used to mark declarations that are intended to be part of the public API of a module, but are not meant to be exposed to consumers of that module.
This annotation is often used in conjunction with inline functions to control the visibility.
Marked functions are used internally within the module but should not be exposed externally.

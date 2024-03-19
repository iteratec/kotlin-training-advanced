# Inline Classes vs Type Aliases

Both tools introduce a new type and represent the underlying type.
Hence, both may be treated as a wrapper.

## Recap Type Alias

Type aliases introduce a new name for existing types.
Mostly used to shorten long names where generics or Maps are involved.

### Examples

```kotlin
typealias IntMap = Map<Integer, MutableList<Integer>>

typealias ShinyFun<T> = (T, IntMap) -> Unit
```

## Differences


* Inline classes introduce a truly new type.
* Type Aliases introduce an alias for existing types

* Type aliases are assignment compatible with the underlying type
* Inline classes are not

## Resources

* https://kotlinlang.org/docs/type-aliases.html

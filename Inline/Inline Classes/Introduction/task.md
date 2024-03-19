# Inline Classes 

Inline classes are effective wrappers of single values.
They are a subset of value-based classes like the primitives Int, Long, etc.

Inline classes behave differently compared to regular classes.
They are represented both as the underlying values type and as a wrapper.
Hence, they do not have a stable identity.
Therefore, reference equality ( === ) is not provided.

## Example: Int

The Kotlin Int class may be represented as the primitive **int** in the JVM platform or as the boxed Integer class.

Inline classes are a tool to allow developers to define value-based classes to provide this behavior.

## Declaration

To declare an inline class the *value* keyword is used. In addition, the `@JvmInline` annotation must be added:

```kotlin
@JvmInline
value class PositiveId(private val value: Long)
```

The inline classes force to initialize a single property in the primary constructor. 
Not more, not less.
Hence, inline classes are wrappers of single values only.

## Benefits

* Effective wrapper classes. At runtime the class overhead is eliminated due to compiler optimization.
* Immutability

## Restrictions

* Inline classes can inherit from interfaces only. No class hierarchies are allowed

## Resources

* https://kotlinlang.org/docs/inline-classes.html

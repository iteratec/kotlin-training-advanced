# Inline Functions

Kotlin offers first class functions.
These let you store functions in variables, pass them as arguments to and return them from other higher-order functions.

As each function is an object, creating higher-order functions leads to a new object creation and memory allocation.

Inline Functions are a powerful feature to improve performance and reduce overhead of higher-order functions.
Marking a function with the `inline` keyword, the compiler replaces every call to that function with the actual function body.
Hence, the function body is inlined at the call site and object creation is avoided.

## Benefits

### Function Body Replacement

Using `inline` on a function the compiler replaces every call to that function with the actual function body of the lambda.
This avoids the overhead of a function call.

### Context Preservation 

Inline functions can access variables from the surrounding scope including private variables.
This possible due to the fact that the code is essentially copied into the call site, so it has access to all the variables available at that location.

### Improves Performance

By eliminating the overhead of function calls, inline functions can improve the performance of your code.
Especially in scenarios calling small functions frequently within loops.

## Example

### Simple Function
```kotlin
// Declaration
fun highOrderFunction(lambda: (String) -> Unit) {
    lambda("Hello World")
}

// Call
highOrderFunction {
    println(it)
}
```

#### Decompiled

> For sake of simplicity the meta information are omitted

```java
public final class MainKt {
   public static final void main() {
      highOrderFunction((Function1)null.INSTANCE);
   }

   // $FF: synthetic method
   public static void main(String[] var0) {
      main();
   }

   public static final void highOrderFunction(@NotNull Function1 lambda) {
      Intrinsics.checkNotNullParameter(lambda, "lambda");
      lambda.invoke("Hello World");
   }
}
```

* There is an instantiation of the lambda -> Function1
* There is a call to `invoke` to trigger the lambda

### As Inline Function

```kotlin
// Declaration
inline fun highOrderFunction(lambda: (String) -> Unit) {
    lambda("Hello World")
}

// Call
highOrderFunction {
    println(it)
}
```

#### Decompiled

> For sake of simplicity the meta information are omitted

```java
public final class MainKt {
    public static final void main() {
        int $i$f$highOrderFunction = false;
        String it = "Hello World";
        int var2 = false;
        System.out.println(it);
    }

    // $FF: synthetic method
    public static void main(String[] var0) {
        main();
    }

    public static final void highOrderFunction(@NotNull Function1 lambda) {
        int $i$f$highOrderFunction = 0;
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        lambda.invoke("Hello World");
    }
}
```

* The `higherOrderFunction` is compiled but not called
* The lambda passed to the function is inlined in the `main()`
* The `println` statement is inlined
* No instantiation of the higher-order function 
* No invocation of the lambda

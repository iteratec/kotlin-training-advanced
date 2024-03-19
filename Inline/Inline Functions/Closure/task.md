# Closure

Lambdas can capture and have access to their surrounding scope, the closure.
The closure needs to maintain the state of the variables.
This is true even after the function has finished executing.

Hence, closures introduce a runtime overhead because additional references must be maintained leading to a memory overhead.

## Facts

### Closure Creation

When a higher-order function creates a closure, it captures references to the variables from its enclosing scope. 
This involves storing these references within the closure object itself.

### Closure Lifetime

The closure is still alive even after the enclosing function has completed execution. 
The closure may still hold references to variables from the enclosing scope.

### Garbage Collection

Closure retains references to variables from the enclosing scope.
Those variables cannot be garbage-collected as long as the closure exists.

### Additional Objects

The closure itself may introduce additional objects or overhead.
Like 
* compiler-generated class to hold the captured variables 
* additional metadata needed to support closures in the runtime environment.

## Decompiled Example

```java
   public static final void main() {
    Function0 counter = createCounter((Function0)null.INSTANCE);
    int var1 = ((Number)counter.invoke()).intValue();
    System.out.println(var1);
    var1 = ((Number)counter.invoke()).intValue();
    System.out.println(var1);
    var1 = ((Number)counter.invoke()).intValue();
    System.out.println(var1);
}

@NotNull
public static final Function0 createCounter(@NotNull Function0 numberCreator) {
    Intrinsics.checkNotNullParameter(numberCreator, "numberCreator");
    final Ref.IntRef count = new Ref.IntRef();
    count.element = ((Number)numberCreator.invoke()).intValue();
    return (Function0)(new Function0() {
        // $FF: synthetic method
        // $FF: bridge method
        public Object invoke() {
            return this.invoke();
        }

        public final int invoke() {
            Ref.IntRef var10000 = count;
            int var1;
            var10000.element = (var1 = var10000.element) + 1;
            return var1;
        }
    });
}
```

## Decompiled with inline keyword

```java
public final class MainKt {
    public static final void main() {
        int $i$f$createCounter = false;
        Ref.IntRef count$iv = new Ref.IntRef();
        int var3 = false;
        int var5 = Random.Default.nextInt(10);
        count$iv.element = var5;
        Function0 counter = (Function0) (new Function0() {
            // $FF: synthetic method
            // $FF: bridge method
            public Object invoke() {
                return this.invoke();
            }

            public final int invoke() {
                Ref.IntRef var10000 = count;
                int var1;
                var10000.element = (var1 = var10000.element) + 1;
                return var1;
            }
        });
        int var6 = ((Number) counter.invoke()).intValue();
        System.out.println(var6);
        var6 = ((Number) counter.invoke()).intValue();
        System.out.println(var6);
        var6 = ((Number) counter.invoke()).intValue();
        System.out.println(var6);
    }
    
    @NotNull
    public static final Function0 createCounter(@NotNull Function0 numberCreator) {
        int $i$f$createCounter = 0;
        Intrinsics.checkNotNullParameter(numberCreator, "numberCreator");
        final Ref.IntRef count = new Ref.IntRef();
        count.element = ((Number)numberCreator.invoke()).intValue();
        return (Function0)(new Function0() {
            // $FF: synthetic method
            // $FF: bridge method
            public Object invoke() {
                return this.invoke();
            }

            public final int invoke() {
                Ref.IntRef var10000 = count;
                int var1;
                var10000.element = (var1 = var10000.element) + 1;
                return var1;
            }
        });
    }
}
```

## Observation

The `inline` keyword doesn't offer any significant benefits.
Inlining a function that returns a lambda with captured variables doesn't get inlined in the call site.
The closure capturing still happens.

The decompiled code has an overhead.
The lambda function to return is compiled twice.
* In the main method as the `counter` function due to the inlining of the `createCounter` higher-order function.
* As separate function `createCounter` which is not used

## Conclusion

The `inline` keyword is no silver bullet for performance optimizations.
Used in the wrong context it will not gain any signification optimizations.
Even worse it will create some code bloat introducing a negative effect.

> It is essential to use keyword with care in the right context to gain benefits.


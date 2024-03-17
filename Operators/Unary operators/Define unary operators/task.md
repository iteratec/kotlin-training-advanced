# Define unary operators

In this task you will add unary operators to a simple class `PowerLevel` that describes the power level
of a pokemon. The required operators are:

* Incrementation - raises the power level by one:
  ```kotlin
  var power = PowerLevel(10)
  assertEquals(++power, PowerLevel(11))
  ```
* Decrementation - lowers the power level by one:
  ```kotlin
  var power = PowerLevel(10)
  assertEquals(--power, PowerLevel(9))
  ```

* Unary minus - returns power level with flipped sign:
  ```kotlin
  assertEquals(-PowerLevel(10), PowerLevel(-10))
  assertEquals(-PowerLevel(-10), PowerLevel(10))
  ```
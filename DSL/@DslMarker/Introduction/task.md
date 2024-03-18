# @DslMarker
The `@DslMarker` annotation allows you to limit the callable members to those of the nearest receiver
and avoid constructions, that don't make sense in DSL context. Consider the following snippet:

```kotlin
fun main() {
    val html = html {
        head {
            title = "My page"
          
            // Outer scope is still reachable, so we can do that
            // ...but header in a header doesn't make any sense
            head {
                title = "My page...again"
            }
        }
    }
}
```
To support cleaner DSL, Kotlin compiler processes the `@DslMarker` annotation, so that the lambda
in the first `head { }` can access only members of the nearest receiver (e.g. `HeadBuilder`).
Accesses to members of outer receivers will result in compilation error.

The `@DslMarker` annotation should be placed on an annotation, that marks our DSL (e.g. `@HtmlDsl`).
Then, the marker annotation (`@HtmlDsl`) should be placed on all receivers that should have
restricted scope. In our example the DSl implementation could look like this:

```kotlin
@DslMarker
annotation class HtmlDsl

fun html(block: HtmlBuilder.() -> Unit): String = 
    HtmlBuilder().apply { block() }.build()

@HtmlDsl
class HtmlBuilder { 
    private var head: Head = Head()

    fun head(block: HeadBuilder.() -> Unit) {
      this.head = HeadBuilder().apply { block() }.build()
    }

    fun build(): String = """
        <html><head><title>${head.title}</title></head></html>
    """.trimIndent()
}

class Head(val title: String = "")

@HtmlDsl
class HeadBuilder {
    var title: String = ""
    fun build(): Head = Head(title)
}
```
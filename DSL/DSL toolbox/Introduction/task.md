# DSL toolbox
Kotlin provides powerful constructs that allow you to define your own DSLs. An example of DSL in Kotlin could be
Gradle DSL or HTML DSL provided in [kotlinx.html](https://github.com/Kotlin/kotlinx.html). In this section we'll
do a recap of language constructs that are helpful, when defining your own DSL.

## Lambda with receiver
Lambdas with receiver are the very heart of DSL constructs in Kotlin. A DSL will usually start with a function, that
accepts a lambda function with some kind of builder object as the receiver:

```kotlin
fun html(block: HtmlBuilder.() -> Unit): String =
    HtmlBuilder().apply { block() }.build()

class HtmlBuilder {
    private var lang: String = "en"
    
    fun lang(lang: String) {
        this.lang = lang 
    }
    
    fun build(): String = """<html lang="$lang"></html>"""
}

fun main() {
    html {
        lang("de")
    }
    .also { println(it) }
}
```

Note, that the DSLs user never instantiates the builders - they are always created in the
methods provided by the DSL. For more complex DSLs you will usually need multiple builders, that
handle configuration of the nested objects.

## Scope interfaces
In the previous example user of the DSL is able to call the `build()` method of `HtmlBuilder`:

```kotlin
fun main() {
    html {
        lang("de")
        build()
    }
}
```

Usually, we don't want to support such calls, but the `HtmlBuilder.build()` method has to remain
public, so it can be called from the `html(HtmlBuilder.() -> Unit)` function. The solution
to this problem is creating a scope interface - you will find many of them in existing DSLs. The
interface exposes just the methods, that are meant to be used within the DSL and allows us
to hide all ìmplementation details of `HtmlBuilder`:

```kotlin
fun html(block: HtmlScope.() -> Unit): String =
    HtmlBuilder().apply { block() }.build()

interface HtmlScope {
    fun lang(lang: String)
}

class HtmlBuilder : HtmlScope {
    private var lang: String = "en"

    override fun lang(lang: String) {
        this.lang = lang
    }

    fun build(): String = """<html lang="$lang"></html>"""
}

fun main() {
    html {
        lang("de")
        // build() not longer visible
    }
    .also { println(it) }
}
```
Using scope interfaces is a good practice, that allows to precisely control members exposed in the DSL.

## Extension functions
Extension functions are useful, when our DSL models an open domain. For instance, when creating a DSL for
HTML, we may want to be able to support custom attributes like `<html my-attribute="value"></html>`.
We don't know all the custom attributes beforehand, so it's better to provide a generic mechanism for
adding them and then, specific attributes can be introduced as extension functions on `HtmlScope`:

```kotlin
fun html(block: HtmlScope.() -> Unit): String =
    HtmlBuilder().apply { block() }.build()

interface HtmlScope {
    fun attribute(name: String, value: String)
}

fun HtmlScope.data(key: String, value: String) {
    attribute("data-$key", value)
}

fun HtmlScope.lang(value: String) {
    attribute("lang", value)
}

class HtmlBuilder : HtmlScope {
    private val attributes: MutableMap<String, String> = mutableMapOf()

    override fun attribute(name: String, value: String) {
        attributes[name] = value
    }

    fun build(): String {
        val attributeString = attributes.entries.joinToString(separator = " ") {
            "${it.key}=\"${it.value}\""
        }
        return "<html $attributeString></html>"
    }
}

fun main() {
    html {
        lang("de")
        data("env", "production")
    }
    .also { println(it) }
}
```
This strategy is frequently used in UI frameworks, when you want to support user-defined components in the
same way as the built-in ones.

## Syntax sugar
Apart from the mentioned features, you have many possibilities to provide a nicer syntax for your DSL
by using overloaded operators or infix functions. However, these constructs should be used with care
as they may easily hurt the readability and make the code less understandable.

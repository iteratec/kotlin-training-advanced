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
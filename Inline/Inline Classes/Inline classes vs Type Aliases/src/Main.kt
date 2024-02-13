
typealias AliasInt = Int

@JvmInline
value class InlineInt(private val value: Int)

fun takeInt(value: Int) {}

fun takeInline(value: InlineInt) {}

fun main() {

    val intValue: Int = 12
    val aliasIntValue: AliasInt = 12

    println(intValue == aliasIntValue)
    println(intValue === aliasIntValue)

    val inlineInt: InlineInt = InlineInt(12)
    println(inlineInt.equals(intValue))

    takeInt(intValue)
    takeInt(aliasIntValue)
    takeInt(14)

    takeInline(inlineInt)


//    Will not compile. Not assignment compatible with the underlying type
//    takeInline(intValue)
//    takeInline(aliasIntValue)
//    takeInline(14)

//     Will not compile. Not assignment compatible with the underlying type
//     val failInlineInt: Int = InlineInt(12)
//     println(intValue == inlineInt)
//     println(intValue === inlineInt)

}

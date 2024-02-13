fun main() {
    // At runtime the class information of PositiveId is not present anymore.
    // The property 'positiveId' is a primitive long in the context of the JVM.
    // Convince yourself by decompiling the kotlin bytecode
    val positiveId: PositiveId = PositiveId(5L)
}

fun main() {
    var charSeqList: MutableList<CharSequence> = mutableListOf()
    var stringList: MutableList<String> = mutableListOf()

    //charSeqList = stringList

    // Now stringList is broken - it contains a StringBuilder
    charSeqList.add(StringBuilder())
}
fun main() {
    fun <T> lengthOfMinimalElement(list: List<T>): Int where T : CharSequence, T : Comparable<T> {
        return list.minOrNull()?.length ?: 0
    }
}

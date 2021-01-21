class Solution {
    fun solution(s: String): String {
        return s.split("").sorted().reversed().joinToString("")
    }
}
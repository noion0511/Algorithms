class Solution {
    fun solution(s: String, n: Int): String =
        s.map {
            when(it) {
                in 'A'..'Z' -> it.caesar(n, 'A', 'Z')
                in 'a'..'z' -> it.caesar(n, 'a', 'z')
                else -> it
            }
        }.joinToString("")
        
    fun Char.caesar(c: Int, n: Char, m: Char): Char =
        (n.toInt() + (toInt() - n.toInt() + c) % (m - n + 1)).toChar()

}

"""
  fun Int.toHello(name: String) {
    println("$name Hello $this")
}
1.toHello("Kim")  // 출력이 되도록 만들고 싶음 = "Kim Hello 1"

확장함수에 대해 알게 되었음,, 모든 타입에 대하여 확장함수를 메소드처럼 추가할 수 있다. 오버라이딩 안됨
"""


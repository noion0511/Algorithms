import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val queue = LinkedList<Int>()
    val sb = StringBuffer()

    for (m in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        when(st.nextToken()) {
            "push" -> {
                queue.add(st.nextToken().toInt())
            }
            "pop" -> {
                if (queue.size > 0) {
                    sb.append("${queue.pollFirst()}\n")
                }
                else {
                    sb.append("-1\n")
                }
            }
            "size" -> {
                sb.append("${queue.size}\n")
            }
            "empty" -> {
                if (queue.size == 0) {
                    sb.append("1\n")
                }
                else {
                    sb.append("0\n")
                }
            }
            "front" -> {
                if (queue.size > 0) {
                    sb.append("${queue.first}\n")
                }
                else {
                    sb.append("-1\n")
                }
            }
            "back" -> {
                if (queue.size > 0) {
                    sb.append("${queue.last}\n")
                }
                else {
                    sb.append("-1\n")
                }
            }
        }
    }

    print(sb.toString())
}
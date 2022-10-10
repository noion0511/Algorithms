import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for(i in 0 until t) {
        val st = StringTokenizer(br.readLine(), " ")
        val n = st.nextToken().toInt()
        var m = st.nextToken().toInt()
        val queue = LinkedList<Int>()
        var count = 0

        val st2 = StringTokenizer(br.readLine(), " ")
        for (j in 0 until n) {
            queue.offerLast(st2.nextToken().toInt())
        }

        while (queue.size > 0) {
            val maximum = queue.maxOrNull()
            val front = queue.pollFirst()
            m -= 1

            if(maximum == front) {
                count += 1
                if(m < 0) {
                    println(count)
                    break
                }
            }
            else {
                queue.offerLast(front)
                if (m < 0) {
                    m = queue.size - 1
                }
            }
        }
    }
}
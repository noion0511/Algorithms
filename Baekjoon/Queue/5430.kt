import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t) {
        val p = br.readLine()
        val n = br.readLine().toInt()
        val st = StringTokenizer(br.readLine().drop(1).dropLast(1), ",")
        val queue = LinkedList<Int>()
        var rev = 0
        var error = 0

        for(j in 0 until n) {
            queue.offerLast(st.nextToken().toInt())
        }

        for (j in p) {
            if (j == 'R') {
                rev += 1
            }
            else if (j == 'D') {
                if (queue.size < 1) {
                    error += 1
                    println("error")
                    break
                }
                else {
                    if (rev % 2 == 0) {
                        queue.pollFirst()
                    }
                    else {
                        queue.pollLast()
                    }
                }
            }
        }

        if (error == 0) {
            if (rev % 2 != 0) queue.reverse()
            println(queue.toString().replace(", ",","))
        }
    }
}
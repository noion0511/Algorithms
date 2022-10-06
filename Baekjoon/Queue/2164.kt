import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val queue = LinkedList<Int>()

    for (i in 1.. n) {
        queue.offerLast(i)
    }

    while (queue.size > 1) {
        queue.pollFirst()
        val a = queue.pollFirst()
        queue.offerLast(a)
    }

    print(queue.poll())
}
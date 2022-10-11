import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")
    var n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val queue = LinkedList<Int>()
    val list = arrayListOf<Int>()
    var count = 0
    var min = 0

    val st2 = StringTokenizer(br.readLine(), " ")
    for(i in 0 until m) {
        list.add(st2.nextToken().toInt())
    }

    for(i in 1 .. n) {
        queue.offerLast(i)
    }

    for (i in list) {
        if (queue.indexOf(i) >= n - queue.indexOf(i)){
            min = n - queue.indexOf(i)
            for (j in 0 until min) {
                val q = queue.pollLast()
                queue.offerFirst(q)
            }
        } else {
            min = queue.indexOf(i)
            for (j in 0 until min) {
                val q = queue.pollFirst()
                queue.offerLast(q)
            }
        }
        queue.pollFirst()
        n -= 1
        count += min
    }

    println(count)
}
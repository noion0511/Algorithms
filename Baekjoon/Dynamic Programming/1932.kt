import java.io.*
import java.util.*

fun main(args: Array<String>)
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){Array(n){0}}

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for(j in 0..i) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    for (i in 1 until n) {
        for(j in 0..i) {
            when(j) {
                0 -> arr[i][j] = arr[i][j] + arr[i-1][j]
                i -> arr[i][j] = arr[i][j] + arr[i-1][j-1]
                else -> arr[i][j] = arr[i][j] + Math.max(arr[i-1][j], arr[i-1][j-1])
            }
        }
    }

    println(arr[n-1].maxOrNull())
}
import java.io.*
import java.util.*

fun main(args: Array<String>)
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){0}
    val dp = Array(n){0}

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        arr[i] = st.nextToken().toInt()
    }

    when(n) {
        1 -> println(arr[0])
        2 -> println(arr[0]+arr[1])
        else -> {
            dp[0] = arr[0]
            dp[1] = arr[1] + dp[0]
            dp[2] = arr[2] + Math.max(dp[0], arr[1])

            for (i in 3 until n) {
                dp[i] = arr[i] + Math.max(dp[i-2], dp[i-3] + arr[i-1])
            }
            println(dp[n-1])
        }
    }
}
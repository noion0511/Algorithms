import java.io.*
import java.util.*

fun main(args: Array<String>)
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){0}
    val dp = Array(n){0}

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    dp[0] = arr[0]

    for (i in 1 until n) {
        dp[i] = Math.max(arr[i], dp[i-1]+arr[i])
    }

    println(dp.maxOrNull())
}
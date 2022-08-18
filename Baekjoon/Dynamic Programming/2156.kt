import java.io.*
import java.util.*
import kotlin.math.max

fun main()
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){0}
    val dp = Array(n){0}

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        arr[i] = st.nextToken().toInt()
    }

    dp[0] = arr[0]

    if (n > 1) {
        dp[1] = arr[0] + arr[1]
    }
    if (n > 2) {
        dp[2] = max(dp[0] + arr[2], max(arr[1] + arr[2], dp[1]))
    }
    if (n > 3) {
        for (i in 3 until n) {
            dp[i] = max(dp[i-2] + arr[i], max(dp[i-3] + arr[i-1] + arr[i], dp[i-1]))
        }
    }

    println(dp.maxOrNull())
}
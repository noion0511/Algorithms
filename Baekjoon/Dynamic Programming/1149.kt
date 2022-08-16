import java.io.*
import java.util.*

fun main(args: Array<String>)
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){Array(3){0} }
    val dp = Array(n){Array(3){0} }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        arr[i][0] = st.nextToken().toInt()
        arr[i][1] = st.nextToken().toInt()
        arr[i][2] = st.nextToken().toInt()
    }

    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][2]

    for (i in 1 until n) {
        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0]
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1]
        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2]
    }

    println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])))
    
}
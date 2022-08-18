import java.io.*
import java.util.*
import kotlin.math.max

fun main()
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n){0}
    val dp = Array(n){1}

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    for(i in 0 until n) {
        for(j in 0 until i) {
            if (arr[i] > arr[j]) {
                dp[i] = max(dp[i], dp[j]+1)
            }
        }
    }

    println(dp.maxOrNull())
}
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()!!.toInt()
    val arr = Array(n){0}
    val dp = Array(n) {1}
    val dp2 = Array(n) {1}
    val result = Array(n){0}

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    for(i in 1 until n) {
        for(j in 0 until i) {
            if (arr[i] > arr[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    arr.reverse()

    for(i in 1 until n) {
        for(j in 0 until i) {
            if (arr[i] > arr[j]) {
                dp2[i] = max(dp2[i], dp2[j] + 1)
            }
        }
    }

    dp2.reverse()

    for (i in 0 until n) {
        result[i] = dp[i] + dp2[i]
    }

    println(result.maxOrNull()?.minus(1) ?: 0)
}
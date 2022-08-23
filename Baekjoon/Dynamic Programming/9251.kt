import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    val m = br.readLine()
    val w = n.length
    val h = m.length
    val dp = Array(h+1){ Array(w+1){0} }

    for(i in 1..h) {
        for (j in 1.. w) {
            if (m[i-1] == n[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1
            }
            else {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
            }
        }
    }

    println(dp[h][w])
}
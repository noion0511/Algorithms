import java.io.*

fun main()
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n+1){ Array(10){0} }

    for (i in 1..9) {
        arr[1][i] = 1
    }

    for (i in 2..n) {
        arr[i][0] = arr[i-1][1]
        arr[i][9] = arr[i-1][8]

        for (j in 1..8) {
            arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000
        }
    }

    var sum = 0L
    arr[n].forEach { sum += it }
    sum %= 1000000000
    println(sum)
}
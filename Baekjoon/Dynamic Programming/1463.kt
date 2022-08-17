import java.io.*

fun main(args: Array<String>)
{
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n+1){0}

    for (i in 2..n) {
        arr[i] = arr[i-1] + 1

        if (i % 2 == 0) {
            arr[i] = Math.min(arr[i], arr[i/2]+1)
        }
        if (i % 3 == 0) {
            arr[i] = Math.min(arr[i], arr[i/3]+1)
        }
    }
    println(arr[n])
}
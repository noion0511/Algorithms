fun main(args: Array<String>)
{
    val n = readLine()!!.toInt()
    val arr = Array(1000001){0}

    arr[1] = 1
    arr[2] = 2

    for (i in 3..n) {
        arr[i] = (arr[i-1] + arr[i-2])%15746
    }

    println(arr[n])
}
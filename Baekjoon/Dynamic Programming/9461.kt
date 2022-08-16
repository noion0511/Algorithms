fun main(args: Array<String>)
{
    val T = readLine()!!.toInt()
    val arr = Array(101){0L}
    arr[1] = 1
    arr[2] = 1

    for (j in 3..100){
        arr[j] = arr[j-3] + arr[j-2]
    }

    for (i in 1..T){
        val n = readLine()!!.toInt()
        println(arr[n])
    }
}
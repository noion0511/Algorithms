var array = Array(21){Array(21){Array(21){0}}}

fun main(args: Array<String>)
{
    while(true) {
        val n = readLine()
        if(n == "-1 -1 -1") break
        val abc = n?.split(" ")!!.map { it.toInt() }.toTypedArray()
        println("w(${abc[0]}, ${abc[1]}, ${abc[2]}) = ${w(abc[0], abc[1], abc[2])}")
    }
}

fun w(a: Int, b: Int, c: Int): Int {
    if(a <= 0 || b <= 0 || c <= 0) {
        return 1
    }
    if(a > 20 || b > 20 || c > 20) {
        return w(20, 20, 20)
    }
    if(array[a][b][c] != 0) {
        return array[a][b][c]
    }
    if(a < b && b < c) {
        array[a][b][c] =  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        return array[a][b][c]
    }

    array[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    return array[a][b][c]
}
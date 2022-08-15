fun main() {
	val value = readLine()!!.toInt()
    val fib = fib(value)
    val fibonacci = fibonacci(value)
    print("$fib $fibonacci")
}

fun fib(n: Int): Int {
    if(n==1 || n==2) {
        return 1
    }
    else {
        return (fib(n-1) + fib(n-2))
    }
}

fun fibonacci(n: Int): Int {
    var count = 0
    var array = Array(n+1, {0})
    array[1] = 1
    array[2] = 1
    
    for(i in 3..n) {
        array[i] = array[i-1] + array[i-2]
        count += 1
    }
    return count
}
class Solution { //문자열을 숫자로 반환하는 함수를 작성하시오
    fun solution(s: String): Int {
        return s.toInt()
        
    }
}


"""
    class Solution { //이게 왜 안되는지 모르겠다... 런타임 에러남
    fun solution(s: String): Int {
        var number = 9
        
        number = Integer.parseInt(s)

        return number
    }
}
"""
class Solution {
    fun solution(n: Long): Long {
        var answer: Long = -1
        var num:Long = 1
        
        while(n >= num) {
            if(n == num*num) {
                answer = (num+1)*(num+1)
                return answer
            }
            num = num + 1
        }
        return answer
    }
}

"""class Solution {
    fun solution(n: Long): Long {
        var answer: Long = -1
        var num:Long = 1
        
        while(n >= num) {
            if(n/num == num) {
                answer = (num+1)*(num+1)
                return answer
            }
            num = num + 1
        }
        return answer
    }
}
    테스트케이스 13번이 안되는데 이유를 모르겠음,, 
    그래서 Math.sqrt(),pow()를 활용하기로 함 

    n/num == num인 조건이 문제 였음,, 5/2==2등이 만족한 듯?
    n = num*num으로 변경
"""


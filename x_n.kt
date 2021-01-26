class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)
        var num = 0
        
        for(i in 1..n){
            num = i * x
            answer[i-1] = num.toLong()
        }

        return answer
    }
}
"""
    오늘도 append 사용법을 익히지 못함.. 계속 오류나서 방법 전환
    정수 x와 자연수 n을 입력받아 x부터 시작해 x씩 증가하는 숫자 n개를 지니는 리스트를 돌려주는 함수
    toLong으로 형변환만 신경쓰면 됨, 아직 코틀린으로 알고리즘 문제푸는건 문법이 잘 기억이 안남
"""
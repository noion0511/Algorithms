class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)
        var num:Long = 0
        var j: Long = 0
        var y:Long = x.toLong()
        
        for(i in 1..n) {
            j = i.toLong()
            num = j * y
            answer[i-1] = num
        }

        return answer
    }
}
"""
    오늘도 append 사용법을 익히지 못함.. 계속 오류나서 방법 전환
    정수 x와 자연수 n을 입력받아 x부터 시작해 x씩 증가하는 숫자 n개를 지니는 리스트를 돌려주는 함수
    toLong으로 형변환만 신경쓰면 됨, 아직 코틀린으로 알고리즘 문제푸는건 문법이 잘 기억이 안남
    ++) 통과 못함 -> 수정
    int로 받아와서 계산하고 long으로 바꾸는 것이 결과 값의 차이를 발생 시킨 것 같음, 바로 long으로 바꾸고 
    계산하니 통과
"""
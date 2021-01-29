import java.util.Calendar

class Solution {
    fun solution(a: Int, b: Int): String {
        val cal  = Calendar.getInstance()
        cal.set(Calendar.YEAR, 2016) //Calendar 클래스 적용 
        cal.set(Calendar.MONTH, a-1)
        cal.set(Calendar.DATE, b)
        var dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
        var day = "MON"
        
        when(dayOfWeek) {
            1 -> day = "SUN"
            2 -> day = "MON"
            3 -> day = "TUE"
            4 -> day = "WED"
            5 -> day = "THU"
            6 -> day = "FRI"
            7 -> day = "SAT"
            else -> day = "MON"
        }
        return day
    }
}
"""
    2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
    두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수
"""
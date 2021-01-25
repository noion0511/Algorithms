class Solution {
    fun solution(s: String): Boolean {
        var s_array = s.toCharArray() //원래는 s.split("")을 사용하려고 했지만 앞뒤로 공백이 하나씩 더 생겨서 toCharArray()로 바꿈
        var s_length = s.length //배열은 처음부터 사이즈를 정해놓고 만들어서 아마 배열의 길이를 구하는 함수가 없는 것 같다.
        var number = 0 //4 또는 6인지 확인할 변수
        
        for(i in 0..s_length-1){// 0부터 s_length까지 구하면 인덱스를 벗어나서 하나를 빼줌
            if(s_array[i] in '0'..'9') {//문자로 들어오기 때문에 0..9가 아닌 '0'..'9' in으로 포함되는 지 확인 가능
                number = number + 1
            }
        }
        if(s_length==4 || s_length==6){
            if(s_length==number){
                return true
            }
        }
        return false
    }
}
"""
    문자열 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수 구하기
    Ex) "a123" -> false, "123456"-> true
"""
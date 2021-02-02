class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        
        for(command in commands) { //for문의 몰랐던 사용방식
            var a = command[0]
            var b = command[1]
            var c = command[2]

            val indice = IntRange(a - 1, b - 1)      //원래 for문을 사용하려고 했으나
            val slice = array.slice(indice).sorted() //slice를 추천 받음 -> 레퍼런스를 자주 보라고 하셨당
            answer.add(slice[c-1])
        }
        return answer.toIntArray() //add 기능을 위해 mutableList로 선언 후 
                                    //타입을 맞추기 위해 toIntArray를 해준다.
    }
}
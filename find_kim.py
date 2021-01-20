"""
String형 배열의 서울 element중에서 kim의 위치를 찾아, /김서방은 x에 있다/를 출력하는 함수 만들기
+)김서방은 3에 있다.로 써서 오류가 발생함. .을 붙이는 것이 습관이라 발견하기 못해서 고생함.
"""
seoul = ["Jane", "Kim"]

def solution(seoul):
    x = 0
    answer = ''
    
    for i in seoul:
        if i != "Kim":
            x = x + 1
        elif i == "Kim":
            answer = "김서방은 {}에 있다".format(x)
    return answer

solution(seoul)
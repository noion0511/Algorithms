"""
길이가 n이고 수박수박수..와 같은 패턴을 유지하는 문자열을 리턴하는 함수 만들기
"""

def solution(n):
    answer = ''

    for i in range(1,n+1):
        if i%2==0:
            answer = answer + '박'
        elif i%2==1:
            answer = answer + '수'
    
    return answer

print(solution(4))
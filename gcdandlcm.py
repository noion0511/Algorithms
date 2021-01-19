""" 
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수 만들기
"""
def gcd(n,m):
        while 1:
            tmp = m%n
            m = n
            n = tmp
            if(tmp==0):
                return m
    
def lcm(n,m):
    return int(n*m/gcd(n,m))

def solution(n,m):
    tmp = 0
    answer = []

    if(n>m):
        n,m = m,n

    tmp = gcd(n,m)
    answer.append(tmp)
    tmp = lcm(n,m)
    answer.append(tmp)
    
    return answer

#테스트
print(solution(2,10))
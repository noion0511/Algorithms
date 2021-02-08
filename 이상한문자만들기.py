def solution(s):
    num = 0
    answer = ""
    
    for str in s:
        if(str == " "):
            answer = answer + str
            num = -1
        elif(num%2==0):
            answer = answer + str.upper()
        elif(num%2==1):
            answer = answer + str.lower()
        num = num + 1
        
    return answer
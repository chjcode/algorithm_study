#numbers : 0~9 숫자배열
#answer : numbers에 없는 숫자 sum

def solution(numbers):
    answer = 0
    
    for i in range(1,10):
        if i not in numbers:
            answer += i
    
    
    return answer
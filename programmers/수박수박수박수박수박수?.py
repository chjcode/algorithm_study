def solution(n):
    repeat = n//2
    answer = "수박" * repeat
    
    if n % 2 != 0:
        answer += "수"
    return answer
def solution(n):
    
    answer = list(str(n))
    answer = sorted(answer, reverse = True)
    answer = ''.join(answer)
    answer = int(answer)
    
    return answer
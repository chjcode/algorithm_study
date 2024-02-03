def solution(n):
    x = int(n**(1/2))
    if n == x*x:
        answer = (x+1) * (x+1)
    else:
        answer = -1
    
    
    return answer
def solution(n):
    
    count = 500
    while count:
        if n == 1:
            break
        if n % 2 == 0:
            n = n//2
        else:
            n *= 3
            n += 1
            
        count -=1
        
    if count:
        answer = 500 - count
    else:
        answer = -1
        
    return answer
def solution(a,b):
    answer = 0
    if a < b:
        minNum = a
        maxNum = b
    else:
        minNum = b
        maxNum = a
        
    for i in range(minNum,maxNum+1):
        answer += i    
    
    return answer
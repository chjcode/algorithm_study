def solution(n,m):
    minNum = min(n,m)
    maxNum = max(n,m)
    
    a = 0   #최대 공약수
    b = 0   #최소 공배수
    
    for i in range(minNum,0,-1):
        if maxNum % i == 0 and minNum % i == 0:
            a = i
            break
    
    b = a * (minNum//a) * (maxNum//a) 
    
    
    return [a,b]

'''
3 12
3, 1, 4

'''

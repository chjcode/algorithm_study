def solution(n):
    answer= 0
    lst = []
    for i in range(1,int(n**(1/2))+1):
        if n % i == 0:
            answer += i
            answer += (n//i)
            lst.append(i)
            lst.append(n//i)
    
    lst.sort()
    print(lst)
    
    return answer
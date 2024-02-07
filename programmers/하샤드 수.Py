def solution(x):
    answer = False
    s_x = sum(list(map(int,list(str(x)))))
    if x % s_x == 0:
        answer = True
    
    
    return answer
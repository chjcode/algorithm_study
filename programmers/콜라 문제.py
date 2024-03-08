def solution(a, b, n):
    answer = 0 
    coke = n
    while True:
        
        add_coke = (coke//a) * b
        answer += add_coke
        now_coke = coke % a
        coke = add_coke + now_coke
        
        if coke < a:
            break
            
    return answer
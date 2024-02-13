def solution(d, budget):
    
    d = sorted(d)
    cnt = 0
    
    for i in d:
        if budget >= i:
            cnt += 1
            budget -= i
        else:
            break
    return cnt
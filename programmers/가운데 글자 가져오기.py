def solution(s):
    
    count = len(s)
    if count % 2 == 0:
        answer = s[count//2-1:count//2+1]
    else:
        answer = s[count//2]
    
    
    return answer
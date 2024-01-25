def solution(s,n):
    answer = list(s)
    alpha = 'abcdefghijklmnopqrstuvwxyz'
    ALPHA = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    
    for i in range(len(s)):
        if answer[i] == ' ':
            continue
        elif answer[i] in alpha:
            answer[i] = alpha[(alpha.index(answer[i]) + n) % 26]
        elif answer[i] in ALPHA:
            answer[i] = ALPHA[(ALPHA.index(answer[i]) + n) % 26]    
        
    return  ''.join(answer)
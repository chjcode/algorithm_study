def solution(dartResult):
    answer = 0
    top = []
    count = 0
    for i in range(len(dartResult)):
        if dartResult[i] == 'S':
            top.append(int(dartResult[i-count:i])**1)
            count = 0
        elif dartResult[i] == 'D':
            top.append(int(dartResult[i-count:i])**2)
            count = 0
        elif dartResult[i] == 'T':
            top.append(int(dartResult[i-count:i])**3)
            count = 0
        elif dartResult[i] == '*':
            top_len = len(top)-1
            if top_len >= 1:
                top[top_len] *= 2
                top[top_len-1] *= 2
            else:
                top[top_len] *= 2
                
        elif dartResult[i] == '#':
            top[-1] *= -1
        else:
            count += 1
    answer = sum(top)
    
    return answer
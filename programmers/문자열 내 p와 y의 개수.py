def solution(s):
    
    answer = False
    countP = 0
    countY = 0
    for alpha in s:
        if 'p' == alpha:
            countP += 1
        elif 'P' == alpha:
            countP += 1
        elif 'y' == alpha:
            countY += 1
        elif 'Y' == alpha:
            countY += 1
    
    if countP == countY:
        answer = True
    
    return answer

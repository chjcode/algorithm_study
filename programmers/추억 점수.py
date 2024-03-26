def solution(name, yearning, photo):
    answer = []
    
    dict  = {}
    for i in range(len(name)):
        dict[name[i]] = yearning[i]
    
    for i in range(len(photo)):
        cnt = 0
        for j in range(len(photo[i])):
            cnt += dict.get(photo[i][j],0)
        answer.append(cnt)
        
    return answer
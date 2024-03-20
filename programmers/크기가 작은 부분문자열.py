def solution(t, p):
    answer = 0
    t_len = len(t)  # t 길이
    p_len = len(p)
    t_lst = []
    for i in range(t_len-p_len+1):
        t_lst.append(t[i:i+p_len])
    
    for i in t_lst:
        if int(i) <= int(p):
            answer += 1
    
    return answer



'''
012345


'''
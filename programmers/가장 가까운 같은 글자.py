def solution(s):
    answer = []
    s_dict = {}

    for i,j in enumerate(s):
        if j not in s_dict.keys():
            s_dict[j] = -1
            
        if s_dict[j] == -1:
            answer.append(-1)
            s_dict[j] = i
        else:
            answer.append(i-s_dict[j])
            s_dict[j] = i
 
    return answer
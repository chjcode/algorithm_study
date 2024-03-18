def solution(s):
    answer = 0
    first = ''
    cnt = True
    end = True
    first_cnt = 0
    other_cnt = 0
    
    for i in s:
        end = True
        if cnt:
            first = i
            first_cnt += 1
            cnt = False
        elif i == first:
            first_cnt += 1
        else:
            other_cnt += 1
        if first_cnt == other_cnt:
            answer += 1
            cnt = True
            first_cnt = 0
            other_cnt = 0
            end = False
    if end:
        answer += 1
    
    return answer
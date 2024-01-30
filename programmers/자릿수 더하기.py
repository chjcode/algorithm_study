def solution(N):
    s_N = str(N)
    answer = 0
    for s_num in s_N:
        answer += int(s_num)
        
    return answer
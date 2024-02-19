def solution(N, stages):
    answer = {}
    stage_len = len(stages)
    
    for i in range(1,N+1):
        if stage_len != 0:
            count = stages.count(i)
            answer[i] = count/stage_len
            stage_len -= count
        else:
            answer[i] = 0
    
    return sorted(answer, key = lambda x : answer[x], reverse = True)
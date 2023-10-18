# 프로그래머스 디스크 컨트롤러

import heapq

def solution(jobs):
    jobs = sorted(jobs, key=lambda x:(x[0],x[1]))
    answer = 0 # 작업하는데 걸린 시간 총 합
    idx = 0 # jobs의 index
    last = -1
    time = jobs[0][0]   # 현재 시간
    wait = []
    while idx < len(jobs):
        for s,t in jobs:
            if last < s <= time:
                heapq.heappush(wait,(t,s))
        if wait:
            last = time
            term, start = heapq.heappop(wait)
            idx += 1
            time += term
            answer += (time-start)
        else:
            time += 1

    return answer // len(jobs)
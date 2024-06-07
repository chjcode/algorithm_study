# 1238.[S/W 문제해결 기본] 10일차 - Contact

from collections import deque

def bfs(start):
    visited = [0 for _ in range(101)]
    visited[start] = 1
    deq = deque()
    deq.append(start)
    cnt = 1

    while deq:
        x = deq.popleft()
        for node in graph[x]:
            if not visited[node]:
                visited[node] = visited[x] + 1
                deq.append(node)

    last_call_lst = []
    last_call = max(visited)
    for i in range(101):
        if visited[i] == last_call:
            last_call_lst.append(i)

    return max(last_call_lst)



t = 10
for tc in range(1,t+1):
    # 입력 받는 데이터의 길이와 시작점
    n, start = map(int,input().split())
    graph = [set() for _ in range(101)]

    lst = list(map(int,input().split()))

    for i in range(0,n,2):
        graph[lst[i]].add(lst[i+1])

    print(f'#{tc} {bfs(start)}')

'''
24 2
100 17 39 22 100 8 100 7 7 100 2 7 2 15 15 4 6 2 11 6 4 10 4 2

#1 17
'''

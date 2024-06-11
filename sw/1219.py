# swea 1219. [S/W 문제해결 기본] 4일차 - 길찾기 git

from collections import deque

def bfs(x):
    deq = deque()
    deq.append(x)


    while deq:
        x = deq.popleft()
        for node in graph[x]:
            if not visited[node]:
                visited[node] = True
                deq.append(node)
    return

for _ in range(1):
    tc, n = map(int,input().split())
    lst = list(map(int,input().split()))
    graph = [[] for _ in range(100)]
    visited = [False for _ in range(100)]
    for i in range(0,2*n,2):
        u,v = lst[i],lst[i+1]
        graph[u].append(v)

    bfs(0)

    print(f'#{tc} {int(visited[99])}')

'''
1 16
0 1 0 2 1 4 1 3 4 8 4 3 2 9 2 5 5 6 5 7 7 99 7 9 9 8 9 10 6 10 3 7

#1 1
'''
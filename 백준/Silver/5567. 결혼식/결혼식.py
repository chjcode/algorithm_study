# 5567 결혼식

from collections import deque
import sys
input = sys.stdin.readline

def bfs(x):
    deq = deque()
    deq.append((x,0))
    visit[x] = True

    while deq:
        x,cnt = deq.popleft()
        if cnt == 2:
            continue
        for node in graph[x]:
            if not visit[node]:
                visit[node] = True
                deq.append((node,cnt+1))

    return

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visit = [False for _ in range(n+1)]
for _ in range(m):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

bfs(1)
print(visit.count(True)-1)
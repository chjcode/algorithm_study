# 11724 연결 요소의 개수

from collections import deque
import sys
input = sys.stdin.readline

def bfs(x):
    deq = deque()
    deq.append(x)
    visit[x] = 1

    while deq:
        x = deq.popleft()
        for node in graph[x]:
            if visit[node] == 0:
                visit[node] = 1
                deq.append(node)

    return

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
visit = [0 for _ in range(n+1)]

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

cnt = 0
for i in range(1,n+1):
    if visit[i] == 0:
        bfs(i)
        cnt += 1

print(cnt)
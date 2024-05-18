import sys
input = sys.stdin.readline

# 2660 회장 뽑기
from collections import deque
def bfs(x):
    deq = deque()
    deq.append(x)
    visit = [-1 for _ in range(n + 1)]
    visit[x] = 0
    while deq:
        x = deq.popleft()
        for node in graph[x]:
            if visit[node] == -1:
                visit[node] = visit[x] + 1
                deq.append(node)

    return max(visit)


n = int(input())
graph = [[] for _ in range(n+1)]
while True:
    u,v = map(int,input().split())
    if u == -1 and v == -1:
        break

    graph[u].append(v)
    graph[v].append(u)

answer = 51
lst = []
for i in range(1,n+1):
    temp = bfs(i)
    if temp < answer:
        answer = temp
        lst = [i]
    elif temp == answer:
        lst.append(i)

print(answer, len(lst))
print(*lst)

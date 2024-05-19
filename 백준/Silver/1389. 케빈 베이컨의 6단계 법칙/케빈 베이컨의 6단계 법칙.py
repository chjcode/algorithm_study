import sys
input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[2e9 for j in range(n+1)] for i in range(n+1)]

for _ in range(m):
    u,v = map(int,input().split())
    graph[u][v] = 1
    graph[v][u] = 1


for i in range(1,n+1):
    for j in range(1,n+1):
        if i == j:
            graph[i][j] = 0

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            graph[i][j] = min(graph[i][j],graph[i][k]+graph[k][j])

cnt = 2e9
answer = 0
for i in range(n, 0, -1):
    s = sum(graph[i][1:])
    if cnt >= s:
        cnt = s
        answer = i
        
print(answer)
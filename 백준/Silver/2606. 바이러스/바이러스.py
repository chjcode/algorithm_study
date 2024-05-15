# 2606 바이러스
import sys
input = sys.stdin.readline

def dfs(x):
    visited[x] = True
    
    for node in graph[x]:
        if not visited[node]:
            dfs(node)
    return

n = int(input())  # 컴퓨터 수
link = int(input())
graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
for _ in range(link):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

dfs(1)

print(visited.count(True)-1)
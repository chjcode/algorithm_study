# 1260 DFS와 BFS

from collections import deque
import sys
input = sys.stdin.readline



def dfs(x):
    global dfs_visit_lst

    d_visited[x] = True
    dfs_visit_lst.append(x)

    for node in sorted(graph[x]):
        if not d_visited[node]:
            d_visited[node] = True
            dfs(node)

    return

def bfs(x):
    global bfs_visit_lst

    visited = [False for _ in range(n+1)]
    visited[x] = True
    bfs_visit_lst.append(x)
    deq = deque()
    deq.append(x)

    while deq:
        x = deq.popleft()
        for node in sorted(graph[x]):
            if not visited[node]:
                visited[node] = True
                bfs_visit_lst.append(node)
                deq.append(node)
    
    return

n,m,v = map(int,input().split())
graph = [[] for _ in range(n+1)]
d_visited = [False for _ in range(n+1)]
for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs_visit_lst = []
bfs_visit_lst = []

dfs(v)
bfs(v)

print(*dfs_visit_lst)
print(*bfs_visit_lst)
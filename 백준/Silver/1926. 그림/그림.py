
import sys
input = sys.stdin.readline
from collections import deque

def bfs(i,j):
    deq = deque()
    deq.append((i,j))
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    graph[i][j] = 0
    cnt = 1

    while deq:
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                continue
            if graph[nx][ny] == 1:
                cnt += 1
                graph[nx][ny] = 0
                deq.append((nx,ny))
    
    return cnt

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
cnt = 0
max_picture = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            cnt += 1
            max_picture = max(max_picture, bfs(i,j))

print(cnt)
print(max_picture)
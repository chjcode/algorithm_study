# (1,1)에서 (n,m)까지 최소 칸 수
from collections import deque
def bfs(x,y):
    deq = deque()
    deq.append([x,y])
    graph[x][y] += 1
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    while deq:
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                deq.append([nx,ny])

n,m = map(int,input().split())
graph = [list(map(int,list(input()))) for _ in range(n)]
bfs(0,0)
print(graph[n-1][m-1]-1)

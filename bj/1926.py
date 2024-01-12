# 그림의 개수, 그림의 넓이 출력 

from collections import deque
def bfs(x,y):
    deq = deque()
    deq.append([x,y])
    graph[x][y] = 0
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    cnt = 1
    while deq:
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                deq.append([nx,ny])
                cnt += 1

    return cnt




n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

biggest_picture = 0
count_picture = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            count_picture += 1
            biggest_picture = max(biggest_picture, bfs(i,j))

print(count_picture)
print(biggest_picture)

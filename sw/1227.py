# swea 1227. [S/W 문제해결 기본] 7일차 - 미로2

from collections import deque

def bfs(x,y):
    deq = deque()
    deq.append((x,y))
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    while deq:
        x,y = deq.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > 99 or ny < 0 or ny > 99:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = 2
                deq.append((nx,ny))
            elif graph[nx][ny] == 3:
                return 1

    return 0

for _ in range(10):
    tc = int(input())
    graph = [list(map(int,list(input()))) for _ in range(100)]
    flag = False
    for i in range(100):
        for j in range(100):
            if graph[i][j] == 2:
                print(f'#{tc} {bfs(i,j)}')
                flag = True
                break
        if flag:
            break

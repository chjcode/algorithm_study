# 2573 빙산
'''
1. 빙산 녹이기
2. bfs() 돌리면서 개수 체크
'''
from collections import deque

def Melting():
    visit = [[0 for j in range(m)] for i in range(n)]
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    for i in range(n):
        for j in range(m):
            if graph[i][j] > 0:
                cnt = 0
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                        continue
                    if graph[nx][ny] == 0:
                        cnt += 1
                visit[i][j] -= cnt
    for i in range(n):
        for j in range(m):
            if graph[i][j] > 0:
                graph[i][j] = max(0,graph[i][j]+visit[i][j])

def Count():
    visit = [[0 for j in range(m)] for i in range(n)]
    cnt = 0 # 빙산 개수
    for i in range(n):
        for j in range(m):
            if graph[i][j] > 0 and visit[i][j] == 0:
                bfs(i,j,visit)
                cnt += 1
            if cnt > 1:
                return cnt
    return cnt

def bfs(i,j,visit):
    deq = deque()
    deq.append([i,j])
    visit[i][j] = 1
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    while deq:
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                continue
            if graph[nx][ny] > 0 and visit[nx][ny] == 0:
                visit[nx][ny] = 1
                deq.append([nx,ny])

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

count_iceberg = Count()   # 처음에 iceberg 개수 count
time = 0
while True:
    if count_iceberg == 0:
        print(0)
        break
    if count_iceberg == 1:
        time += 1
        Melting()
        # print()
        # for i in range(n):
        #     print(*graph[i])
        count_iceberg = Count()
        # print('c : ',count_iceberg)
    else:
        print(time)
        break
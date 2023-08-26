# 2589 보물섬

from collections import deque
# import sys
# input = sys.stdin.readline

def bfs(x,y):
    deq = deque()
    deq.append([x,y])
    visit = [[0 for j in range(m)] for i in range(n)]
    visit[x][y] = 1
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    cnt = 0

    while deq:
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                continue
            if graph[nx][ny] == 'L' and visit[nx][ny] == 0:
                deq.append([nx,ny])
                visit[nx][ny] = visit[x][y] + 1
                cnt = max(visit[nx][ny],cnt)

    return cnt-1




# 입력 받기
n,m = map(int,input().split())
graph = [list(input()) for _ in range(n)]

max_cnt = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'L':
            if 0 <= (j-1) and (j+1) < m: # 그래프 좌우 범위 벗어나지 않는지 확인
                if graph[i][j-1] == 'L' and graph[i][j+1] == 'L':   # 좌우 모두 L이면 건너 뜀
                    continue
            if 0 <= (i-1) and (i+1) < n:    # 그래프 상하 범위 벗어나지 않는지 확인
                if graph[i-1][j] == 'L' and graph[i+1][j] == 'L':
                    continue

            max_cnt = max(max_cnt,bfs(i,j))

print(max_cnt)
# 14940 쉬운 최단거리
'''
도달할 수 없는 위치 -1 출력 -> 따로 for문 돌려서 검사 후 bfs()

'''

from collections import deque

# 2. 목표 지점 좌표 찾는 함수 구현
def Search():
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                # 3. 탐색
                Bfs(i,j)
                return

# 3. bfs 탐색 함수 구현
def Bfs(x,y):
    deq = deque()
    deq.append([x,y])
    graph[x][y] = 0
    visit[x][y] = True
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]

    while deq:
        x,y = deq.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                continue
            if graph[nx][ny] == 1 and visit[nx][ny] == False:
                graph[nx][ny] = graph[x][y] + 1
                visit[nx][ny] = True
                deq.append([nx,ny])
    # 도달할 수 없는 위치 -1로
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1 and visit[i][j] == False:
                graph[i][j] = -1




# 1. 입력 받기
# n: 가로(행,x), m: 세로(열,y)
n,m = map(int,input().split())

graph = []
visit = [[False for j in range(m)] for i in range(n)]
for i in range(n):
    graph.append(list(map(int,input().split())))

# 2. 목표 지점 좌표찾기
Search()

# 4. 출력
for i in range(n):
    print(*graph[i])
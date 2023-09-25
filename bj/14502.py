# 14502 연구소

from collections import deque

# 벽세우는 함수, 백트래킹
def makeWall(cnt):
    global answer
    if cnt == 3:
        answer = max(answer,bfs())
        return

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                makeWall(cnt+1)
                graph[i][j] = 0

# bfs
def bfs():
    temp = [t[:] for t in graph] # graph 복사
    deq = deque()
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    for i in range(n):  # 2(바이러스)의 위치 정보 수집
        for j in range(m):
            if temp[i][j] == 2:
                deq.append([i,j])

    cnt = 0 # 바이러스가 퍼진 영역의 개수
    while deq:  # bfs돌려서 바이러스 퍼트리면서 퍼트린 면적 계산
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                continue
            if temp[nx][ny] == 0:
                temp[nx][ny] = 2
                cnt += 1
                deq.append([nx,ny])

    # 남은 safe_area 개수 반환
    return safe_area-cnt-3  # 처음 safe_area의 면적 - 바이러스 퍼진 면적 - 벽 3개




# 입력 받기
n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

# 처음 safe_area의 개수
safe_area = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            safe_area += 1

# 벽 세우고 안전 영역 크기 확인하기
answer = 0
makeWall(0)

print(answer)

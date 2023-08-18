# 2638 치즈

from collections import deque

def Check(x,y):
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    cnt = 0

    for i in range(4):  # 상하좌우 공기 체크
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
            continue
        if air_graph[nx][ny] == 1:    # 외부 공기이면 cnt + 1
            cnt += 1
    if cnt > 1: # 1시간 뒤 녹을 치즈면
        graph[x][y] = 0 # 치즈 녹이기
        return True
    return False



# 외부 공기 전부 1로 표시
def Air():
    deq = deque()
    deq.append([0,0])
    air_graph[0][0] = 1
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    while deq:
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                continue
            if graph[nx][ny] == 0 and air_graph[nx][ny] == 0:
                air_graph[nx][ny] = 1
                deq.append([nx,ny])
    return



# 1. 입력 받기
n,m = map(int,input().split())

graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))

time = 0
cheese = True

while cheese:   # 치즈가 녹을 때마다 외부/내부공기가 바뀜
    cheese = False
    air_graph = [[0 for j in range(m)] for i in range(n)] # 내부 / 외부 공기 판단
    Air()   # 가장자리는 외부공기니까 가장자리부터 bfs 돌려버리면 다 외부공기인 1로 채워짐
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:    # 치즈를 만나면
                if Check(i,j):   # 한 시간 뒤 녹을 치즈인지 판단하고 녹이기
                    cheese = True   # 치즈 하나라도 녹으면 True
    if cheese:  # 치즈가 하나라도 녹았으면
        time += 1   # 시간 추가

print(time)
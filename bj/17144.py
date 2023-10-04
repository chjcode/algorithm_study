# 17144 미세먼지 안녕!
'''
-  미세먼지 확산 (큰값 작은값 상관 없이 확산)
1. for문 돌려서 상하좌우 확산 -> 서로 영향 없이 동시에 하려면?

-  공기청정기 작동(바람이 안 부는 가운데 공간은 그대로)
1. 한 칸씩 밀면서 하면 될듯?

'''
# 미세먼지 확산 함수
def Spread():
    add = [[0 for j in range(c)] for i in range(r)]
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    for i in range(r):
        for j in range(c):
            if graph[i][j] > 0:
                spread = graph[i][j]//5     # 주변으로 퍼질 미세먼지 양 계산
                cnt = 0     # 몇 방향으로 퍼지는지 count
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if nx < 0 or nx > (r-1) or ny < 0 or ny > (c-1):    # graph 바깥으로 나가면 continue
                        continue
                    if graph[nx][ny] == -1: # 공기 청정기를 만나면 continue
                        continue
                    cnt += 1
                    add[nx][ny] += spread
                add[i][j] -= spread * cnt     # 주변에 퍼진 양 만큼 (-)

    for i in range(r):
        for j in range(c):
            graph[i][j] += add[i][j]

# 위쪽 공기 순환 함수
def AirPurifierUp():
    up_x = xloc[0]

    # 왼쪽
    for i in range(up_x-1,0,-1):
        graph[i][0] = graph[i-1][0]
    # 위쪽
    for j in range(0,c-1):
        graph[0][j] = graph[0][j+1]
    # 오른쪽
    for i in range(0,up_x):
        graph[i][c-1] = graph[i+1][c-1]
    # 아래쪽
    for j in range(c-2,0,-1):
        graph[up_x][j+1] = graph[up_x][j]
    graph[up_x][1] = 0

# 아래쪽 공기 순환 함수
def AirPurifierDown():
    down_x = xloc[1]

    # 왼쪽
    for i in range(down_x+1,r-1):
        graph[i][0] = graph[i+1][0]
    # 아래쪽
    for j in range(0,c-1):
        graph[r-1][j] = graph[r-1][j+1]
    # 오른쪽
    for i in range(r-1,down_x-1,-1):
        graph[i][c-1] = graph[i-1][c-1]
    # 위쪽
    for j in range(c-1,1,-1):
        graph[down_x][j] = graph[down_x][j-1]
    graph[down_x][1] = 0



# 공기 청정기 위치 찾는 함수
def AirPurifierXLoc():
    for i in range(r):
        if graph[i][0] == -1:
            return [i,i+1]


# 전체 미세먼지량 구하는 함수
def totalDust():
    total_dust = 0
    for i in range(r):
        for j in range(c):
            if graph[i][j] > 0:
                total_dust += graph[i][j]
    return total_dust

# 입력 받기
r,c,t = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(r)]

# total_dust = totalDust()    # 전체 미세먼지량
xloc = AirPurifierXLoc()  # 공기 청정기 위치

for _ in range(t):
    Spread()
    # print('확산')
    # for i in range(r):
    #     print(*graph[i])
    # print()
    AirPurifierUp()
    AirPurifierDown()
    # print('회전')
    # for i in range(r):
    #     print(*graph[i])
    # print()
print(totalDust())   # 전체 미세먼지량
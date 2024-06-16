# 1211. [S/W 문제해결 기본] 2일차 - Ladder2

def dfs(x,y,start):
    global answer

    if x == n-1:
        if answer[1] > visit[x][y]:
            answer = [start,visit[x][y]]
        return

    for i in range(2):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx > (n-1) or ny < 0 or ny > (n-1):
            continue
        if graph[nx][ny] == 1 and visit[nx][ny] == 0:
            visit[nx][ny] = visit[x][y] + 1
            dfs(nx,ny,start)
            return
    if graph[x+1][y] == 1 and visit[x+1][y] == 0:
        visit[x+1][y] = visit[x][y] + 1
        dfs(x+1,y,start)
    return



for _ in range(10):
    tc = int(input())
    n = 100
    graph = [list(map(int,input().split())) for _ in range(n)]
    answer = [0,2e9]
    dx = [0,0]
    dy = [-1,1]
    for j in range(n):
        if graph[0][j] == 1:
            visit = [[0 for j in range(n)] for i in range(n)]
            visit[0][j] = 1
            dfs(0,j,j)

    print(f'#{tc} {answer[0]}')

'''
input
1
1 0 1 0 1
1 1 1 0 1
1 1 1 0 1
1 0 1 1 1
1 0 1 0 1

output
7

1
1 0 1 0 1 0 1
1 1 1 0 1 0 1
1 1 1 0 1 0 1
1 0 1 0 1 0 1
1 0 1 1 1 0 1
1 0 1 0 1 1 1
1 0 1 0 1 0 1


'''
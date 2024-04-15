# swea 11315. 오목 판정

def dfs(depth,x,y,k):
    global flag

    if depth == 5:
        flag = True
        return

    nx = x + dx[k]
    ny = y + dy[k]
    if nx < 0 or nx > (n-1) or ny < 0 or ny > (n-1):
        return
    if graph[nx][ny] == 'o':
        dfs(depth+1,nx,ny,k)
    return

def find(n):
    for i in range(n):
        for j in range(n):
            for k in range(8):
                if graph[i][j] == 'o':
                    dfs(1,i,j,k)
                if flag:
                    return

t = int(input())

for tc in range(1,t+1):
    n = int(input())
    graph = [list(input()) for _ in range(n)]
    visit = [[0 for _ in range(n)] for _ in range(n)]
    dx = [-1,-1,-1,0,0,1,1,1]
    dy = [-1,0,1,-1,1,-1,0,1]
    flag = False

    find(n)

    if flag:
        print(f'#{tc} YES')
    else:
        print(f'#{tc} NO')


import sys
input = sys.stdin.readline

def dfs(x,y,depth,alpha):
    global cnt

    if alpha == s[:depth]:
        if alpha == s:
            cnt += 1
            return
        for i in range(8):
            nx = (x + dx[i]) % n
            ny = (y + dy[i]) % m

            dfs(nx,ny,depth+1,alpha+graph[nx][ny])



# 입력 받기
n,m,k = map(int,input().split())
graph = [list(input()) for _ in range(n)]

dx = [-1,-1,-1,0,0,1,1,1]
dy = [-1,0,1,-1,1,-1,0,1]

for _ in range(k):
    s = input()
    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == s[0]:
                dfs(i,j,1,s[0])
    print(cnt)
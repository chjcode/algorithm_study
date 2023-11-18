# swea 4615.재미있는 오셀로 게임

# B : 흑돌, W : 백돌
# 흑돌부터 시작
# 다른 색 나오면 계속 감 -> 그러다 같은 색 만나면

import sys
sys.stdin = open("sample_input(1).txt")

def check(x,y,dx,dy):
    nx = x + dx
    ny = y + dy
    stack = []
    while True:
        if nx < 0 or nx > (n - 1) or ny < 0 or ny > (n - 1):
            return []
        if graph[nx][ny] == 0:
            return []
        if graph[nx][ny] == c:
            return stack
        if graph[nx][ny] != c:
            stack.append([nx,ny])
            nx += dx
            ny += dy


T = int(input())
for test_case in range(1,T+1):
    n,m = map(int,input().split())  # n : 보드 한 변의 길이, m : 플레이어 돌 놓는 횟수
    graph = [[0 for j in range(n)] for i in range(n)]
    # 초기 돌 배치
    graph[n//2][n//2] = 2
    graph[n//2-1][n//2-1] = 2
    graph[n//2][n//2-1] = 1
    graph[n//2-1][n//2] = 1
    # 방향 설정
    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
    dy = [-1, 0, 1, -1, 1, -1, 0, 1]
    for i in range(m):
        x,y,c = map(int,input().split())
        x -= 1  # 문제는 1,1이 0,0이므로
        y -= 1
        graph[x][y] = c
        for i in range(8):
            stack = check(x,y,dx[i],dy[i])
            for a,b in stack:
                graph[a][b] = c
    cnt_b = 0
    cnt_w = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1:
                cnt_b += 1
            elif graph[i][j] == 2:
                cnt_w +=1
    print(f"#{test_case} {cnt_b} {cnt_w}")
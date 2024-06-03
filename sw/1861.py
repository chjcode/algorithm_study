# swea 1861. 정사각형 방 -> dfs + 메모이제이션

def dfs(x,y):
    if dp[x][y]:
        return

    dp[x][y] = 1    # 자기 자신도 count에 포함되므로

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx > (n-1) or ny < 0 or ny > (n-1):
            continue
        if graph[nx][ny] == graph[x][y] + 1:
            dfs(nx,ny)
            dp[x][y] = max(dp[x][y], dp[nx][ny] + 1)

    return

t = int(input())

for tc in range(1,t+1):
    n = int(input())
    graph = [list(map(int,input().split())) for _ in range(n)]
    dp = [[0 for j in range(n)] for i in range(n)]
    answer = 0
    room_num = 2e9

    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    for i in range(n):
        for j in range(n):
            dfs(i,j)


    for i in range(n):
        for j in range(n):
            if (dp[i][j] > answer) or (room_num > graph[i][j] and dp[i][j] == answer):
                answer = dp[i][j]
                room_num = graph[i][j]

    print(f'#{tc} {room_num} {answer}')

'''
입력
2
2
1 2
3 44
3
9 3 4
6 1 5
7 8 2

input.txt
출력
#1 1 2
#2 3 3
'''
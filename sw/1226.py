# swea 1226. 미로1 -> bfs

from collections import deque
def bfs(x,y):
    global flag
    deq = deque()
    deq.append([x,y])
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    while deq:
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > 15 or ny < 0 or ny > 15:
                continue
            if graph[nx][ny] == 3:
                flag = True
                return
            if graph[nx][ny] == 0:
                graph[nx][ny] = 2
                deq.append([nx,ny])



for _ in range(10):
    test_case = int(input())
    graph = [list(map(int,list(input()))) for _ in range(16)]


    flag = False
    b_flag = False
    for i in range(16):
        for j in range(16):
            if graph[i][j] == 2:
                bfs(i,j)
                b_flag = True
                if flag:
                    print(f"#{test_case} {1}")
                break
        if b_flag:
            break
    if not flag:
        print(f"#{test_case} {0}")


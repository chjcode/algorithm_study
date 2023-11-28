# swea 1210. Ladder1 -> dfs

def dfs(x,y):
    global graph
    if x == 0:
        print(f"#{test_case} {y}")
        return

    graph[x][y] = 0
    if (y-1) >= 0 and graph[x][y-1] == 1:
        dfs(x,y-1)
    elif (y+1) < 100 and graph[x][y+1] == 1:
        dfs(x,y+1)
    else:
        dfs(x-1,y)
    return

for _ in range(10):
    test_case = int(input())
    graph = [list(map(int,input().split())) for _ in range(100)]

    for j in range(100):
        if graph[99][j] == 2:
            dfs(99,j)
            break
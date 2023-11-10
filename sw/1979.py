# swea 1979. 어디에 단어가 들어갈 수 있을까

def dfs(dx,dy,i,j,cnt):
    global count
    if i < 0 or i > (n-1) or j < 0 or j > (n-1):
        return
    if graph[i][j] == 0:
        return
    count = max(count,cnt)
    dfs(dx,dy,i+dx,j+dy,cnt+1)

t = int(input())
for test_case in range(1,t+1):
    n,k = map(int,input().split())
    graph = [list(map(int,input().split())) for _ in range(n)]
    dx = [0,1]
    dy = [1,0]
    m_dx = [0,-1]
    m_dy = [-1,0]
    answer = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1:
                for m in range(2):
                    nx = i + m_dx[m]
                    ny = j + m_dy[m]
                    if not (nx < 0 or nx > (n-1) or ny < 0 or ny > (n-1)):
                        if graph[nx][ny] == 1:
                            continue
                    count = 0
                    dfs(dx[m],dy[m],i,j,1)
                    print(count)
                    if count == k:
                        answer += 1
                        print(count,answer)

    print(f'#{test_case} {answer}')
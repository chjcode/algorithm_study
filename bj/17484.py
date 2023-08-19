# 17484 진우의 달 여행

# 백트래킹 함수 구현
def dfs(x,y,depth,derection,cnt):
    global money
    # 행렬 맨 아래 행까지 탐색 후 그 동안 들었던 비용과 현재 최소값이 저장되어있는 money와 비교
    if depth == n:
        money = min(money,cnt)
        return

    for i in range(3):  # 3방향으로 탐색 시작
        if derection == i:  # 같은 방향일 때는 continue
            continue
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
            continue

        dfs(nx,ny,depth+1,i,cnt+graph[nx][ny])
    return

# 1. 입력받기
n,m = map(int,input().split())
graph = [list(map(int,input().split())) for i in range(n)]

# 대각선 왼쪽아래, 아래, 대각선 오른쪽아래 방향
dx = [1,1,1]
dy = [-1,0,1]
money = 600 # n이 최대 6이므로 각 셀당 100 곱하면 최대 600 나올 수 있다.

for i in range(m):
    dfs(0,i,1,-1,graph[0][i])   # 첫번째 행 각 열에서 출발

print(money)
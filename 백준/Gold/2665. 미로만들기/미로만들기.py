from collections import deque

def bfs(x,y):
    deq = deque()
    deq.append((x,y))
    visit[x][y] = 0

    while deq:
        x,y = deq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx > (n-1) or ny < 0 or ny > (n-1):
                continue
            if graph[nx][ny] == 1:  # 벽이 이어져 있는 곳이면
                # 새로 방문한 곳이 이전 방문보다 값이 크면 이미 이전에 방문했지만 효율적이지 않은 루트로 접근한 것이기 때문에 다시 탐색
                if visit[nx][ny] > visit[x][y]: 
                    visit[nx][ny] = visit[x][y]
                    deq.append((nx,ny))
                
            else:   # 막혀있는 곳 뚫고 지나가는 거면
                # 새로 방문한 곳이 이전 방문 + 1 보다 값이 크면 이미 이전에 방문했지만 효율적이지 않은 루트로 접근한 것이기 때문에 다시 탐색
                if visit[nx][ny] > visit[x][y] + 1:
                    visit[nx][ny] = visit[x][y] + 1
                    deq.append((nx,ny))



# n = 8
# s = '1110011011010010100110101110110001000111001100011101100011000111'
# graph = []
# for i in range(n):
    # graph.append(list(map(int,list(s[i*8:i*8+8]))))
n = int(input())
graph = [list(map(int,list(input()))) for _ in range(n)]
visit = [[2e9 for j in range(n)] for i in range(n)]
dx = [0,0,-1,1]
dy = [-1,1,0,0]

bfs(0,0)
print(visit[-1][-1])
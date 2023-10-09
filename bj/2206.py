from collections import deque

def bfs(x,y,wall):
  deq = deque()
  deq.append([x,y,wall])
  visited[x][y][0] = 1

  while deq:
    x,y,wall = deq.popleft()
    if x == (N-1) and y == (M-1):
      return visited[x][y][wall]
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or nx > (N-1) or ny < 0 or ny > (M-1):
        continue
      if graph[nx][ny] == 1 and wall == 0:
        deq.append([nx,ny,1])
        visited[nx][ny][1] = visited[x][y][wall] +1
      elif graph[nx][ny] == 0 and visited[nx][ny][wall] == 0:
        deq.append([nx,ny,wall])
        visited[nx][ny][wall] = visited[x][y][wall] + 1

  
  return -1
      


N,M = map(int,input().split())

#graph
graph = []
for i in range(N):
  graph.append(list(map(int,input())))
visited = [[[0]*2 for _ in range(M)] for _ in range(N)]
#move
dx = [0,0,1,-1]
dy = [1,-1,0,0]

print(bfs(0,0,0))
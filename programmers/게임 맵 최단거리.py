# from collections import deque
# # 1: 길, 0: 벽
# def solution(maps):
#     global n,m,dx,dy,deq
#     n = len(maps)   #세로
#     m = len(maps[0])    #가로
#     #move
#     dx = [0,0,1,-1]
#     dy = [1,-1,0,0]
    
#     deq = deque()
#     deq.append([0,0])
    
#     return bfs(maps)

# def bfs(maps):
#     global dx,dy,deq,n,m
#     while deq:
#         x,y = deq.popleft()
#         if x == (n-1) and y == (m-1):
#             return maps[x][y]
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]
#             if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
#                 continue
#             if maps[nx][ny] == 1:
#                 maps[nx][ny] = maps[x][y] + 1
#                 deq.append([nx,ny])
    
#     return -1
    
    
    
from collections import deque    
def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    def bfs(x,y):
        deq = deque()
        deq.append([x,y])
        dx = [0,0,-1,1]
        dy = [1,-1,0,0]
        maps[x][y] += 1
        while deq:
            x,y = deq.popleft()
            if x == (n-1) and y == (m-1):
                return maps[n-1][m-1] - 1
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                    continue
                if maps[nx][ny] == 1:
                    deq.append([nx,ny])
                    maps[nx][ny] = maps[x][y] + 1
        
        return -1            
    
    return bfs(0,0)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
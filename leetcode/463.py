# class Solution:
#     def islandPerimeter(self, grid: List[List[int]]) -> int:

#         dx = [0,0,-1,1]
#         dy = [-1,1,0,0]
#         n = len(grid)
#         m = len(grid[0])
#         cnt = 0
#         for i in range(n):
#             for j in range(m):
#                 if grid[i][j] == 1:
#                     for k in range(4):
#                         nx = i + dx[k]
#                         ny = j + dy[k]
#                         if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
#                             cnt += 1
#                             continue
#                         if grid[nx][ny] == 0:
#                             cnt += 1

#         return cnt

from collections import deque

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:

        def check4Directions(x,y):
            cnt = 0
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                    cnt += 1
                    continue
                if grid[nx][ny] == 0:
                    cnt += 1
            return cnt

        def bfs(x,y):
            deq = deque()
            deq.append([x,y])
            count = 0
            grid[x][y] = -1
            count += check4Directions(x,y)

            while deq:
                x,y = deq.popleft()
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                        continue
                    if grid[nx][ny] == 1:
                        grid[nx][ny] = -1
                        count += check4Directions(nx,ny)
                        deq.append([nx,ny])
            return count

        dx = [0,0,-1,1]
        dy = [-1,1,0,0]
        n = len(grid)
        m = len(grid[0])
        perimeter = 0
        flag = False
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    perimeter = bfs(i,j)
                    flag = True
                    break
            if flag:
                break

        return perimeter
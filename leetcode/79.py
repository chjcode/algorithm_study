class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(x,y,depth):
            if depth == len(word):
                nonlocal answer
                answer = True
                return

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or nx > (n-1) or ny < 0 or ny > (m-1):
                    continue
                if board[nx][ny] == word[depth] and visit[nx][ny] == False:
                    visit[nx][ny] = True
                    dfs(nx,ny,depth+1)
                    visit[nx][ny] = False
                    
            return

        n = len(board)
        m = len(board[0])
        answer = False
        dx = [0,0,-1,1]
        dy = [-1,1,0,0]

        for i in range(n):
            for j in range(m):
                if board[i][j] == word[0]:
                    visit = [[False for _ in range(m)]for _ in range(n)]
                    visit[i][j] = True
                    dfs(i,j,1)
                if answer == True:
                    return answer
        return answer

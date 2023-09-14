from collections import deque

def solution(n,computers):
    answer = 0
    visited = [False for _ in range(n)]
    
    def bfs(x,visited):        
        visited[x] = True
        deq = deque([x])
        
        while deq:
            x = deq.popleft()
            for i in range(n):
                if computers[x][i]==1 and visited[i]==False:
                    visited[i] = True
                    deq.append(i)
    
    for i in range(n):
        if not visited[i]:
            bfs(i,visited)
            answer += 1
    
    return answer
from collections import deque

def bfs():
    deq = deque()
    deq.append([1,0])
    visit[1] = True

    while deq:
        x, cnt = deq.popleft()
        if cnt == 2:
            continue
        for i in graph[x]:
            if visit[i] == False:
                deq.append([i,cnt+1])
                visit[i] = True
                
    return

n = int(input())
m = int(input())

# 친구와 친구의 친구까지 초대
graph = [[] for _ in range(n+1)]
visit = [False for _ in range(n+1)]
for i in range(m):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

bfs()
# print(visit)
print(visit.count(True)-1)